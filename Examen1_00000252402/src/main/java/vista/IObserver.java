package vista;

/**
 * Interfaz que define la función de un Observador (Observer) en el patrón de
 * diseño Observer. Toda clase que implemente esta interfaz podrá ser notificada
 * de los cambios de estado del Sujeto (Subject) al que está suscrito.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public interface IObserver {

    /**
     * Método llamado por el Sujeto para notificar al Observador de un cambio de
     * estado. El Observador debe implementar la lógica para actualizar su
     * propia vista o estado.
     */
    public void update();
}
