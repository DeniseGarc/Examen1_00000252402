package modeloNegocio;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoSeleccionadoDTO;
import modelo.IModeloUpdater;
import modelo.ModelVistaFacade;
import mapper.ProductoMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Clase que implementa la interfaz IModeloNegocio. Es la capa que contiene la
 * lógica de negocio pura de la aplicación (validaciones, cálculos, gestión del
 * carrito). Utiliza el patrón Singleton y se comunica con el ModelVistaFacade a
 * través de la interfaz IModeloUpdater.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ModeloNegocioImp implements IModeloNegocio {

    /**
     * Instancia única (Singleton) de la clase ModeloNegocioImp.
     */
    private static ModeloNegocioImp instance;

    /**
     * Interfaz usada para actualizar la capa de presentación
     * (ModelVistaFacade).
     */
    private IModeloUpdater modeloUpdater = ModelVistaFacade.getInstance();

    /**
     * Lista que contiene la información de identificación bancaria (BIN) para
     * la validación de tarjetas.
     */
    private List<BINInfo> binInfo = new ArrayList<>();

    /**
     * Mapa que almacena los productos seleccionados por el usuario, usando el
     * NegocioProducto como clave y la cantidad como valor. Representa el
     * carrito de compras.
     */
    private Map<NegocioProducto, Integer> productosSeleccionados = new HashMap<>();

    /**
     * Lista completa de productos disponibles en el catálogo de la aplicación.
     */
    private List<NegocioProducto> productos = new ArrayList<>();

    /**
     * Constructor privado para forzar el uso del patrón Singleton.
     */
    private ModeloNegocioImp() {
    }

    /**
     * Obtiene la instancia única de la clase ModeloNegocioImp (patrón
     * Singleton).
     *
     * @return La instancia única de ModeloNegocioImp.
     */
    public static ModeloNegocioImp getInstance() {
        if (instance == null) {
            instance = new ModeloNegocioImp();
        }
        return instance;
    }

    /**
     * Establece la lista de información BIN utilizada para validar y obtener
     * detalles de la tarjeta.
     *
     * @param binInfo La lista de objetos BINInfo.
     */
    public void setBinInfo(List<BINInfo> binInfo) {
        this.binInfo = binInfo;
    }

    /**
     * Implementación para obtener la información del banco y ciudad del emisor
     * a partir del número de tarjeta, validando el formato y el BIN. Los
     * resultados son notificados a la capa de presentación a través de
     * modeloUpdater.
     *
     * @param numeroTarjeta El número de tarjeta de 16 dígitos.
     */
    @Override
    public void obtenerInfoTarjeta(String numeroTarjeta) {
        DetallesTarjetaDTO tarjeta = new DetallesTarjetaDTO();

        if (numeroTarjeta.trim().isEmpty()) {
            return;
        }

        if (numeroTarjeta.trim().matches("\\d{16}")) {
            String bin = numeroTarjeta.substring(0, 6);
            for (BINInfo info : binInfo) {
                if (info.getPrefijoBIN().equals(bin)) {
                    tarjeta.setBancoEmisor(info.getBancoEmisor());
                    tarjeta.setCiudadEmisor(info.getCiudadEmisor());
                    tarjeta.setNumeroTarjeta(numeroTarjeta);
                    modeloUpdater.actualizarDatosTarjeta(tarjeta);
                    return;
                }
            }
            tarjeta.setNumeroTarjeta("BIN no encontrado");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        } else {
            tarjeta.setNumeroTarjeta("Número de tarjeta inválido");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        }
    }

    /**
     * Implementación para agregar o actualizar la cantidad de un producto en el
     * carrito de compras. Calcula el nuevo estado del carrito y lo notifica a
     * la vista.
     *
     * @param productoDTO DTO del producto y la cantidad seleccionada.
     */
    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoDTO) {

        NegocioProducto negocioProducto = null;
        int cantidadNueva = productoDTO.getCantidad();
        for (NegocioProducto productoCatalogo : productos) {
            if (productoDTO.getNombre().equals(productoCatalogo.getNombre())) {
                negocioProducto = productoCatalogo;
                break;
            }
        }

        if (negocioProducto == null) {
            // Manejar el caso de producto no encontrado en el catálogo.
            return;
        }

        if (productosSeleccionados.containsKey(negocioProducto)) {
            int cantidadAnterior = productosSeleccionados.get(negocioProducto);
            int cantidadTotal = cantidadAnterior + cantidadNueva;
            productosSeleccionados.put(negocioProducto, cantidadTotal);
        } else {
            productosSeleccionados.put(negocioProducto, cantidadNueva);
        }

        List<ProductoSeleccionadoDTO> seleccionaActualizada = new ArrayList<>();

        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            ProductoSeleccionadoDTO dto = new ProductoSeleccionadoDTO();
            NegocioProducto producto = entry.getKey();
            int cantidad = entry.getValue();
            dto.setNombre(producto.getNombre());
            dto.setCantidad(cantidad);
            dto.setSubtotal(producto.getCosto() * cantidad);
            seleccionaActualizada.add(dto);
        }
        modeloUpdater.actualizarProductosSeleccionados(seleccionaActualizada);
    }

    /**
     * Implementación para procesar el pago de la compra. Calcula el total, crea
     * el DTO de información de compra y notifica el resultado. Finalmente,
     * vacía el carrito de compras.
     */
    @Override
    public void pagarCompra() {
        double total = 0;
        List<ProductoSeleccionadoDTO> productosDTO = new ArrayList<>();
        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            total += entry.getKey().getCosto() * entry.getValue();
        }

        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            ProductoSeleccionadoDTO dto = new ProductoSeleccionadoDTO();
            dto.setNombre(entry.getKey().getNombre());
            dto.setCantidad(entry.getValue());
            dto.setSubtotal(entry.getKey().getCosto() * entry.getValue());
            productosDTO.add(dto);
        }

        InfoCompraDTO infoCompra = new InfoCompraDTO(productosDTO, total, null);
        modeloUpdater.pagarProductos(infoCompra);
        productosSeleccionados.clear();
    }

    /**
     * Implementación para agregar un nuevo producto al catálogo disponible. El
     * producto es agregado a la lista local y notificado a la capa de vista.
     *
     * @param producto El producto de negocio a agregar.
     */
    @Override
    public void agregarProducto(NegocioProducto producto) {
        productos.add(producto);
        modeloUpdater.agregarProducto(ProductoMapper.toDTO(producto));
    }

}
