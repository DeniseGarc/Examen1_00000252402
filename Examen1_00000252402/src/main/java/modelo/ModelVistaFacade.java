package modelo;

import java.util.ArrayList;
import java.util.List;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import mapper.ProductoMapper;

/**
 *
 * @author Alici
 */
public class ModelVistaFacade extends Subject implements IModeloUpdater, IModeloVista {

    private static ModelVistaFacade instance;
    private List<Producto> productos;
    private List<ProductoSeleccionado> productosSeleccionados;
    private InfoCompra detallesCompra = new InfoCompra("", false);

    private ModelVistaFacade() {
    }

    public static ModelVistaFacade getInstance() {
        if (instance == null) {
            instance = new ModelVistaFacade();
        }
        return instance;
    }

    @Override
    public void agregarProducto(ProductoDTO producto) {
        Producto productoGuardar = ProductoMapper.toEntity(producto);
        productos.add(productoGuardar);
        notifyObservers();
    }

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

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        ProductoSeleccionado producto = new ProductoSeleccionado();
        for (Producto p : productos) {
            if (p.getNombre().equals(productoSeleccionado.getNombre())) {
                producto = new ProductoSeleccionado(p, productoSeleccionado.getCantidad());
                break;
            }
        }
        productosSeleccionados.add(producto);
        notifyObservers();
    }

    @Override
    public void pagarProductos(InfoCompraDTO infoCompra) {
        if (detallesCompra.isEsTarjetaValida()) {
            StringBuilder ticket = new StringBuilder();

            String header = String.format("==========Resumen de compra==========");
            String separadorTotal = String.format("============Total==============");
            String separadorTarjeta = String.format("==========Datos de la tarjeta==========");

            ticket.append(header).append("\n");
            for (ProductoSeleccionadoDTO producto : infoCompra.getProductos()) {
                ticket.append(String.format("\n$d $25s $.2f", producto.getCantidad(), producto.getNombre(),
                        producto.getSubtotal())).append("\n");
            }
            ticket.append(separadorTotal).append("\n");
            ticket.append(String.format("Total.....................$.2f\n", infoCompra.getTotal()));
            ticket.append(separadorTarjeta).append("\n");
            ticket.append(detallesCompra.getTexto() + "\n");
            detallesCompra.setTexto(ticket.toString());
            notifyObservers();
        }

    }

    @Override
    public List<ProductoDTO> obtenerProductos() {
        List<ProductoDTO> productoDTOs = new ArrayList<>();
        for (Producto producto : productos) {
            productoDTOs.add(ProductoMapper.toProductoDTO(producto));
        }
        return productoDTOs;
    }

    @Override
    public List<ProductoSeleccionadoDTO> obtenerProductosSeleccionados() {
        List<ProductoSeleccionadoDTO> productoSeleccionadoDTOs = new ArrayList<>();
        for (ProductoSeleccionado producto : productosSeleccionados) {
            productoSeleccionadoDTOs.add(ProductoMapper.toProductoSeleccionadoDTO(producto));
        }
        return productoSeleccionadoDTOs;
    }

    @Override
    public String obtenerDetalles() {
        return detallesCompra.getTexto();
    }

    @Override
    public boolean obtenerValidezTarjeta() {
        return detallesCompra.isEsTarjetaValida();
    }

    @Override
    public double obtenerTotalProductos() {
        double total = 0;
        for (ProductoSeleccionado productoSeleccionado : productosSeleccionados) {
            total = +productoSeleccionado.getSubtotal();
        }
        return total;
    }

}
