package dtos;

/**
 * Clase DTO (Data Transfer Object) para encapsular la información básica de un
 * producto. Se utiliza para transferir el nombre y el costo unitario de un
 * producto entre las distintas capas de la aplicación.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ProductoDTO {

    /**
     * El nombre descriptivo del producto.
     */
    private String nombre;

    /**
     * El costo o precio unitario del producto.
     */
    private double costo;

    /**
     * Constructor por defecto (sin argumentos) de la clase ProductoDTO.
     */
    public ProductoDTO() {
    }

    /**
     * Constructor que inicializa el nombre y el costo del producto.
     *
     * @param nombre El nombre del producto.
     * @param costo El costo o precio unitario del producto.
     */
    public ProductoDTO(String nombre, double costo) {
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
     *
     */
    public void setCosto(double costo) {
        this.costo = costo;
    }

}
