package dtos;

import java.util.List;

/**
 *
 * @author Alici
 */
public class InfoCompraDTO {

    private List<ProductoSeleccionadoDTO> productos;
    private double total;
    private DetallesTarjetaDTO detallesTarjeta;

    public InfoCompraDTO() {
    }

    public InfoCompraDTO(List<ProductoSeleccionadoDTO> productos, double total, DetallesTarjetaDTO detallesTarjeta) {
        this.productos = productos;
        this.total = total;
        this.detallesTarjeta = detallesTarjeta;
    }

    public List<ProductoSeleccionadoDTO> getProductos() {
        return productos;
    }

    public void setProductos(List<ProductoSeleccionadoDTO> productos) {
        this.productos = productos;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public DetallesTarjetaDTO getDetallesTarjeta() {
        return detallesTarjeta;
    }

    public void setDetallesTarjeta(DetallesTarjetaDTO detallesTarjeta) {
        this.detallesTarjeta = detallesTarjeta;
    }

}
