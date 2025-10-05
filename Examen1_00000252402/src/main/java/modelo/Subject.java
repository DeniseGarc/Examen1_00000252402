package modelo;

import java.util.ArrayList;
import java.util.List;
import vista.IObserver;

/**
 * Clase abstracta que representa el sujeto (Observable) en el patrón Observer.
 * Se encarga de mantener una lista de observadores y notificarles sobre
 * cualquier cambio de estado. Las clases de modelo que necesitan ser observadas
 * deben heredar de esta.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public abstract class Subject {

    /**
     * Lista de observadores registrados que serán notificados de los cambios.
     */
    private List<IObserver> observers = new ArrayList<>();

    /**
     * Registra un nuevo observador en la lista.
     *
     * @param observer El observador a añadir.
     */
    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    /**
     * Notifica a todos los observadores registrados para que actualicen su
     * estado.
     */
    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update();
        }
    }
}
