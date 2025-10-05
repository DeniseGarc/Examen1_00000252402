package dtos;

/**
 * Clase DTO (Data Transfer Object) para encapsular los detalles de una tarjeta.
 * Esta clase se utiliza para transferir información relevante sobre la tarjeta,
 * como su número, el banco emisor y la ciudad de emisión, entre capas de la
 * aplicación.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 */
public class DetallesTarjetaDTO {

    /**
     * El número de la tarjeta.
     */
    private String numeroTarjeta;

    /**
     * El nombre del banco que emitió la tarjeta.
     */
    private String bancoEmisor;

    /**
     * La ciudad donde se emitió la tarjeta.
     */
    private String ciudadEmisor;

    /**
     * Constructor por defecto (sin argumentos) de la clase DetallesTarjetaDTO.
     */
    public DetallesTarjetaDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param numeroTarjeta El número de la tarjeta.
     * @param bancoEmisor El nombre del banco emisor.
     * @param ciudadEmisor La ciudad de emisión de la tarjeta.
     */
    public DetallesTarjetaDTO(String numeroTarjeta, String bancoEmisor, String ciudadEmisor) {
        this.numeroTarjeta = numeroTarjeta;
        this.bancoEmisor = bancoEmisor;
        this.ciudadEmisor = ciudadEmisor;
    }

    /**
     * Obtiene el número de la tarjeta.
     *
     * @return El número de la tarjeta.
     */
    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    /**
     * Establece o actualiza el número de la tarjeta.
     *
     * @param numeroTarjeta El nuevo número de la tarjeta a establecer.
     */
    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    /**
     * Obtiene el nombre del banco emisor.
     *
     * @return El nombre del banco emisor.
     */
    public String getBancoEmisor() {
        return bancoEmisor;
    }

    /**
     * Establece o actualiza el nombre del banco emisor.
     *
     * @param bancoEmisor El nuevo nombre del banco emisor a establecer.
     */
    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    /**
     * Obtiene la ciudad de emisión de la tarjeta.
     *
     * @return La ciudad de emisión.
     */
    public String getCiudadEmisor() {
        return ciudadEmisor;
    }

    /**
     * Establece o actualiza la ciudad de emisión de la tarjeta.
     *
     * @param ciudadEmisor La nueva ciudad de emisión a establecer.
     */
    public void setCiudadEmisor(String ciudadEmisor) {
        this.ciudadEmisor = ciudadEmisor;
    }
}
