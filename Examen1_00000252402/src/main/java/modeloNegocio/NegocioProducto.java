package modeloNegocio;

/**
 * Clase del modelo de negocio que representa la información básica de un
 * producto. Se utiliza para manejar los datos del producto dentro de la capa de
 * lógica de negocio.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class NegocioProducto {

    /**
     * El nombre descriptivo del producto.
     */
    private String nombre;

    /**
     * El costo o precio unitario del producto.
     */
    private double costo;

    /**
     * Constructor por defecto (sin argumentos) de la clase NegocioProducto.
     */
    public NegocioProducto() {
    }

    /**
     * Constructor que inicializa el nombre y el costo del producto.
     *
     * @param nombre El nombre del producto.
     * @param costo El costo o precio unitario del producto.
     */
    public NegocioProducto(String nombre, double costo) {
        this.nombre = nombre;
        this.costo = costo;
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
     * Obtiene el costo o precio unitario del producto.
     *
     * @return El costo del producto.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece o actualiza el costo o precio unitario del producto.
     *
     * @param costo El nuevo costo del producto a establecer.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
