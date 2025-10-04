/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;


/**
 *
 * @author Alici
 */
public class ModelObserver implements IObserver {

    private PantallaPrincipal framePrincipal = PantallaPrincipal.getInstance();

    @Override
    public void update() {
        framePrincipal.actualizarVista();
    }

}
