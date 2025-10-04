package arrancador;

import vista.PantallaPrincipal;

/**
 * Clase principal donde se va a configurar el modelo de negocio y arrancar el
 * programa
 *
 * @author Alicia Denise García Acosta
 */
public class Main {

    public static void main(String[] args) {
        PantallaPrincipal pantallaPrincipal = PantallaPrincipal.getInstance();
        pantallaPrincipal.setVisible(true);
    }
}
