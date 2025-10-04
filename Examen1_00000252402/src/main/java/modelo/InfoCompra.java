/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alici
 */
public class InfoCompra {
    private String texto;
    private boolean esTarjetaValida;

    public InfoCompra() {
        this.texto = "";
    }

    public InfoCompra(String texto, boolean esTarjetaValida) {
        this.texto = texto;
        this.esTarjetaValida = esTarjetaValida;
    }

    public boolean isEsTarjetaValida() {
        return esTarjetaValida;
    }

    public void setEsTarjetaValida(boolean esTarjetaValida) {
        this.esTarjetaValida = esTarjetaValida;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void actualizarDatosTarjeta(String detallesTarjeta) {
        texto = detallesTarjeta;
        esTarjetaValida = true;
    }

    public void actualizarInfoCompra(String detallesCompra) {
        texto = detallesCompra;
        esTarjetaValida = true;
    }
}
