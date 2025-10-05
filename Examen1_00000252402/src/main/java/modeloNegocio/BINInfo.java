package modeloNegocio;

/**
 * Clase del modelo que almacena información de identificación bancaria (BIN) de
 * las tarjetas, usada para validar y obtener detalles del emisor de una
 * tarjeta.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class BINInfo {

    /**
     * Los primeros seis dígitos de una tarjeta, conocidos como Prefijo BIN.
     */
    private String prefijoBIN;

    /**
     * El nombre de la institución bancaria que emitió la tarjeta.
     */
    private String bancoEmisor;

    /**
     * La ciudad de origen del banco emisor de la tarjeta.
     */
    private String ciudadEmisor;

    /**
     * Constructor por defecto de la clase BINInfo.
     */
    public BINInfo() {
    }

    /**
     * Constructor que inicializa todos los atributos de la información BIN.
     *
     * @param prefijoBIN El prefijo de los primeros seis dígitos de la tarjeta.
     * @param bancoEmisor El nombre del banco emisor.
     * @param ciudadEmisor La ciudad del banco emisor.
     */
    public BINInfo(String prefijoBIN, String bancoEmisor, String ciudadEmisor) {
        this.prefijoBIN = prefijoBIN;
        this.bancoEmisor = bancoEmisor;
        this.ciudadEmisor = ciudadEmisor;
    }

    /**
     * Obtiene el prefijo BIN (los primeros seis dígitos) de la tarjeta.
     *
     * @return El prefijo BIN.
     */
    public String getPrefijoBIN() {
        return prefijoBIN;
    }

    /**
     * Establece el prefijo BIN de la tarjeta.
     *
     * @param prefijoBIN El nuevo prefijo BIN.
     */
    public void setPrefijoBIN(String prefijoBIN) {
        this.prefijoBIN = prefijoBIN;
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
     * Establece el nombre del banco emisor.
     *
     * @param bancoEmisor El nuevo nombre del banco emisor.
     */
    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    /**
     * Obtiene la ciudad del banco emisor.
     *
     * @return La ciudad del banco emisor.
     */
    public String getCiudadEmisor() {
        return ciudadEmisor;
    }

    /**
     * Establece la ciudad del banco emisor.
     *
     * @param ciudadEmisor La nueva ciudad del banco emisor.
     */
    public void setCiudadEmisor(String ciudadEmisor) {
        this.ciudadEmisor = ciudadEmisor;
    }

}
