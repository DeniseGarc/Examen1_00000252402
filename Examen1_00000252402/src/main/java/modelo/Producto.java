package modelo;

/**
 * Clase del modelo que representa un producto dentro del catálogo de la
 * aplicación. Esta clase contiene la información esencial de un producto:
 * nombre y costo unitario.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class Producto {

    /**
     * Nombre descriptivo del producto.
     */
    private String nombre;

    /**
     * Costo o precio unitario del producto.
     */
    private double costo;

    /**
     * Constructor por defecto de la clase Producto.
     */
    public Producto() {
    }

    /**
     * Constructor que inicializa todos los atributos del producto.
     *
     * @param nombre El nombre del producto.
     * @param costo El costo unitario del producto.
     */
    public Producto(String nombre, double costo) {
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
     * Establece el nombre del producto.
     *
     * @param nombre El nuevo nombre del producto.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el costo unitario del producto.
     *
     * @return El costo del producto.
     */
    public double getCosto() {
        return costo;
    }

    /**
     * Establece el costo unitario del producto.
     *
     * @param costo El nuevo costo del producto.
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
