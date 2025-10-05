package dtos;

/**
 * Clase DTO (Data Transfer Object) que representa un producto seleccionado
 * dentro de un carrito de compras o una transacción. Contiene información sobre
 * el producto específico, la cantidad requerida y el subtotal calculado para
 * esa línea de producto.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ProductoSeleccionadoDTO {

    /**
     * El nombre del producto seleccionado.
     */
    private String nombre;

    /**
     * La cantidad de unidades de este producto que se han seleccionado.
     */
    private int cantidad;

    /**
     * El costo total para este producto (cantidad * precio unitario).
     */
    private double subtotal;

    /**
     * Constructor por defecto (sin argumentos) de la clase
     * ProductoSeleccionadoDTO.
     */
    public ProductoSeleccionadoDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param nombre El nombre del producto seleccionado.
     * @param cantidad La cantidad de unidades seleccionadas.
     * @param subtotal El subtotal de la línea de producto.
     */
    public ProductoSeleccionadoDTO(String nombre, int cantidad, double subtotal) {
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.subtotal = subtotal;
    }

    /**
     * Obtiene el nombre del producto.
     *
     * @return El nombre del producto.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece o actualiza el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto a establecer.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene la cantidad de unidades seleccionadas.
     *
     * @return La cantidad de unidades.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece o actualiza la cantidad de unidades seleccionadas.
     *
     * @param cantidad La nueva cantidad de unidades a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    /**
     * Obtiene el subtotal de la línea de producto.
     *
     * @return El subtotal calculado.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Establece o actualiza el subtotal de la línea de producto.
     *
     * @param subtotal El nuevo subtotal a establecer.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
