package vista;

/**
 * Clase que actúa como un Observador concreto (Concrete Observer) para el
 * modelo de la aplicación. Implementa la interfaz IObserver y es responsable de
 * notificar a la vista principal (PantallaPrincipal) cuando el estado del
 * modelo ha cambiado y requiere una actualización.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ModelObserver implements IObserver {

    /**
     * Referencia a la instancia única de la ventana principal de la aplicación.
     * Se utiliza para invocar la actualización de la interfaz de usuario.
     */
    private PantallaPrincipal framePrincipal = PantallaPrincipal.getInstance();

    /**
     * Método de actualización invocado por el Sujeto cuando hay un cambio de
     * estado. Este método delega la tarea de refrescar los datos y la interfaz
     * de usuario llamando al método actualizarVista() de la PantallaPrincipal.
     */
    @Override
    public void update() {
        framePrincipal.actualizarVista();
    }

}
