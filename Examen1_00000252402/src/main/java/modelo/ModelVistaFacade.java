package modelo;

import java.util.ArrayList;
import java.util.List;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import mapper.ProductoMapper;

/**
 * Clase Facade que actúa como el punto central de comunicación entre la capa de
 * negocio y las vistas.
 *
 * Implementa los patrones Singleton y Observer (al extender Subject) para
 * notificar a las vistas sobre los cambios de estado. También implementa las
 * interfaces IModeloUpdater (recibe actualizaciones del negocio) e IModeloVista
 * (las vistas consultan el estado).
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ModelVistaFacade extends Subject implements IModeloUpdater, IModeloVista {

    /**
     * Instancia única (Singleton) de la clase ModelVistaFacade.
     */
    private static ModelVistaFacade instance;

    /**
     * Lista que contiene el catálogo completo de productos disponibles.
     */
    private List<Producto> productos = new ArrayList<>();

    /**
     * Lista que contiene los productos que han sido seleccionados por el
     * usuario (carrito).
     */
    private List<ProductoSeleccionado> productosSeleccionados = new ArrayList<>();

    /**
     * Objeto que almacena los detalles de la tarjeta y la información de la
     * compra/estado actual.
     */
    private InfoCompra detallesCompra = new InfoCompra("", false);

    /**
     * Constructor privado para forzar el uso del patrón Singleton.
     */
    private ModelVistaFacade() {
    }

    /**
     * Obtiene la instancia única de la clase ModelVistaFacade (patrón
     * Singleton).
     *
     * @return La instancia única de ModelVistaFacade.
     */
    public static ModelVistaFacade getInstance() {
        if (instance == null) {
            instance = new ModelVistaFacade();
        }
        return instance;
    }

    /**
     * Agrega un nuevo producto al catálogo interno de la fachada. Notifica a
     * los observadores sobre el cambio en la lista de productos.
     *
     * @param producto DTO del producto a agregar.
     */
    @Override
    public void agregarProducto(ProductoDTO producto) {
        Producto productoGuardar = ProductoMapper.toEntity(producto);
        productos.add(productoGuardar);
        notifyObservers();
    }

    /**
     * Actualiza la información de la tarjeta de pago y su estado de validez.
     * Crea un resumen de los detalles de la tarjeta y notifica a los
     * observadores.
     *
     * @param detallesTarjeta DTO que contiene el número, banco y ciudad emisora
     * de la tarjeta.
     */
    @Override
    public void actualizarDatosTarjeta(DetallesTarjetaDTO detallesTarjeta) {
        if (!(detallesTarjeta.getNumeroTarjeta().matches("\\d{16}"))) {
            detallesCompra = new InfoCompra(detallesTarjeta.getNumeroTarjeta(), false);
            notifyObservers();
            return;
        }

        String detalles = String.format("Tarjeta: %s\nBanco Emisor: %s\nCiudad Emisor: %s",
                detallesTarjeta.getNumeroTarjeta(),
                detallesTarjeta.getBancoEmisor(),
                detallesTarjeta.getCiudadEmisor());
        detallesCompra = new InfoCompra(detalles, true);
        notifyObservers();
    }

    /**
     * Actualiza la lista interna del carrito de compras con la nueva selección
     * de productos. Notifica a los observadores sobre el cambio en el carrito.
     *
     * @param productosSeleccionados Lista de DTOs con los productos y
     * cantidades seleccionadas.
     */
    @Override
    public void actualizarProductosSeleccionados(List<ProductoSeleccionadoDTO> productosSeleccionados) {
        List<ProductoSeleccionado> seleccionActualizada = new ArrayList<>();
        for (ProductoSeleccionadoDTO dto : productosSeleccionados) {
            for (Producto producto : productos) {
                if (dto.getNombre().equals(producto.getNombre())) {
                    ProductoSeleccionado seleccion = new ProductoSeleccionado(producto, dto.getCantidad(),
                            dto.getSubtotal());
                    seleccionActualizada.add(seleccion);
                }
            }
        }
        this.productosSeleccionados = seleccionActualizada;
        notifyObservers();
    }

    /**
     * Procesa la finalización de la compra. Si la tarjeta fue validada, genera
     * un ticket de compra detallado y notifica a los observadores.
     *
     * @param infoCompra DTO con los detalles finales de la compra y el total.
     */
    @Override
    public void pagarProductos(InfoCompraDTO infoCompra) {
        if (detallesCompra.isEsTarjetaValida()) {
            detallesCompra.setEsTarjetaValida(false);
            StringBuilder ticket = new StringBuilder();

            String header = String.format("==========Resumen de compra==========");
            String separadorTotal = String.format("============Total==============");
            String separadorTarjeta = String.format("==========Datos de la tarjeta==========");

            ticket.append(header).append("\n");
            for (ProductoSeleccionadoDTO producto : infoCompra.getProductos()) {
                ticket.append(String.format("%d %-25s $%.2f", producto.getCantidad(), producto.getNombre(),
                        producto.getSubtotal())).append("\n");
            }
            ticket.append(separadorTotal).append("\n");
            ticket.append(String.format("Total.....................$%.2f\n", infoCompra.getTotal()));
            ticket.append(separadorTarjeta).append("\n");
            ticket.append(detallesCompra.getTexto() + "\n");
            detallesCompra.setTexto(ticket.toString());
            notifyObservers();
        }

    }

    /**
     * Proporciona la lista completa de productos disponibles en el catálogo en
     * formato DTO.
     *
     * @return Lista de ProductoDTOs.
     */
    @Override
    public List<ProductoDTO> obtenerProductos() {
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        if (!(productos.isEmpty())) {
            for (Producto producto : productos) {
                productoDTOs.add(ProductoMapper.toProductoDTO(producto));
            }
        }
        return productoDTOs;
    }

    /**
     * Proporciona la lista actual de productos en el carrito de compras en
     * formato DTO.
     *
     * @return Lista de ProductoSeleccionadoDTOs.
     */
    @Override
    public List<ProductoSeleccionadoDTO> obtenerProductosSeleccionados() {
        List<ProductoSeleccionadoDTO> productoSeleccionadoDTOs = new ArrayList<>();
        if (!(productosSeleccionados.isEmpty())) {
            for (ProductoSeleccionado producto : productosSeleccionados) {
                productoSeleccionadoDTOs.add(ProductoMapper.toProductoSeleccionadoDTO(producto));
            }
        }
        return productoSeleccionadoDTOs;
    }

    /**
     * Obtiene el texto descriptivo del estado actual (detalles de tarjeta o
     * ticket de compra).
     *
     * @return El texto de los detalles de la compra.
     */
    @Override
    public String obtenerDetalles() {
        return detallesCompra.getTexto();
    }

    /**
     * Obtiene el estado actual de validez de la tarjeta de pago.
     *
     * @return true si la tarjeta es válida, false en caso contrario.
     */
    @Override
    public boolean obtenerValidezTarjeta() {
        return detallesCompra.isEsTarjetaValida();
    }

    /**
     * Calcula y obtiene el total acumulado de todos los productos en el carrito
     * de compras.
     *
     * @return El total de la compra.
     */
    @Override
    public double obtenerTotalProductos() {
        double total = 0;
        for (ProductoSeleccionado productoSeleccionado : productosSeleccionados) {
            total += productoSeleccionado.getSubtotal();
        }
        return total;
    }

}
