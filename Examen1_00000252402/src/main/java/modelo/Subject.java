/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.ArrayList;

/**
 *
 * @author Alici
 */

import java.util.List;

import vista.IObserver;

public abstract class Subject {

    private List<IObserver> observers = new ArrayList<>();

    public void addObserver(IObserver observer) {
        observers.add(observer);
    }

    public void notifyObservers() {
        for (IObserver observer : observers) {
            observer.update(this);
        }
    }
}
