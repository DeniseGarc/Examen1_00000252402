package modelo;

/**
 * Clase del modelo que representa un producto que ha sido seleccionado y
 * añadido al carrito de compras. Contiene la información específica de la
 * selección, incluyendo la cantidad y el subtotal calculado.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ProductoSeleccionado {

    /**
     * Referencia al objeto Producto del catálogo original.
     */
    private Producto producto;

    /**
     * El subtotal calculado para la cantidad seleccionada (costo * cantidad).
     */
    private double subtotal;

    /**
     * La cantidad de unidades de este producto que han sido seleccionadas.
     */
    private int cantidad;

    /**
     * Constructor por defecto de la clase ProductoSeleccionado.
     */
    public ProductoSeleccionado() {
    }

    /**
     * Constructor que inicializa el producto, la cantidad y calcula el subtotal
     * en base al costo del producto y la cantidad.
     *
     * @param producto El producto base seleccionado.
     * @param cantidad La cantidad de unidades seleccionadas.
     * @param subtotal Este parámetro es utilizado para recibir datos del DTO,
     * pero el subtotal se recalcula internamente.
     */
    public ProductoSeleccionado(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        // Se asegura que el subtotal se calcule correctamente desde el modelo.
        this.subtotal = producto.getCosto() * cantidad;
    }

    /**
     * Obtiene el producto base seleccionado.
     *
     * @return El objeto Producto.
     */
    public Producto getProducto() {
        return producto;
    }

    /**
     * Establece el producto base y actualiza el subtotal.
     *
     * @param producto El nuevo objeto Producto a establecer.
     */
    public void setProducto(Producto producto) {
        this.producto = producto;
        actualizarSubtotal();
    }

    /**
     * Obtiene el subtotal calculado (costo * cantidad).
     *
     * @return El subtotal de la selección.
     */
    public double getSubtotal() {
        return subtotal;
    }

    /**
     * Obtiene la cantidad de unidades seleccionadas.
     *
     * @return La cantidad del producto.
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Establece la cantidad de unidades seleccionadas y actualiza el subtotal.
     *
     * @param cantidad La nueva cantidad a establecer.
     */
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        actualizarSubtotal();
    }

    /**
     * Método privado para recalcular el subtotal en base al producto y la
     * cantidad actuales.
     */
    private void actualizarSubtotal() {
        if (producto != null) {
            this.subtotal = producto.getCosto() * cantidad;
        } else {
            this.subtotal = 0;
        }
    }

    /**
     * Establece manualmente el subtotal.
     *
     * @param subtotal El nuevo subtotal.
     */
    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
