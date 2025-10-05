package modelo;

/**
 * Clase de modelo que encapsula la información de una compra, incluyendo
 * mensajes de estado y el resultado de la validación de la tarjeta.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class InfoCompra {

    /**
     * Campo de texto genérico usado para almacenar mensajes o detalles (e.g.,
     * detalles de la tarjeta o de la compra).
     */
    private String texto;

    /**
     * Indicador booleano que señala si la tarjeta de crédito o débito ha sido
     * validada exitosamente.
     */
    private boolean esTarjetaValida;

    /**
     * Constructor por defecto. Inicializa el campo de texto a una cadena vacía.
     */
    public InfoCompra() {
        this.texto = "";
    }

    /**
     * Constructor que inicializa todos los atributos de la información de
     * compra.
     *
     * @param texto El mensaje o detalle a almacenar.
     * @param esTarjetaValida Estado de validación de la tarjeta.
     */
    public InfoCompra(String texto, boolean esTarjetaValida) {
        this.texto = texto;
        this.esTarjetaValida = esTarjetaValida;
    }

    /**
     * Obtiene el estado de validación de la tarjeta.
     *
     * @return true si la tarjeta es válida, false en caso contrario.
     */
    public boolean isEsTarjetaValida() {
        return esTarjetaValida;
    }

    /**
     * Establece el estado de validación de la tarjeta.
     *
     * @param esTarjetaValida El nuevo estado de validación.
     */
    public void setEsTarjetaValida(boolean esTarjetaValida) {
        this.esTarjetaValida = esTarjetaValida;
    }

    /**
     * Obtiene el mensaje o texto descriptivo almacenado.
     *
     * @return El texto actual.
     */
    public String getTexto() {
        return texto;
    }

    /**
     * Establece o actualiza el mensaje o texto descriptivo.
     *
     * @param texto El nuevo texto a establecer.
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

}
