package dtos;

/**
 *
 * @author Alici
 */
public class ProductoSeleccionadoDTO {

    private String nombre;
    private int cantidad;
    private double subtotal;

    public ProductoSeleccionadoDTO() {
    }

    public ProductoSeleccionadoDTO(String nombre, int cantidad, double subtotal) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
