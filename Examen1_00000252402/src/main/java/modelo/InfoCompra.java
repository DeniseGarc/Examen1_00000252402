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

    public InfoCompra() {
        this.texto = "";
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public void actualizarDatosTarjeta(String detallesTarjeta) {
        texto = detallesTarjeta;
    }

    public void actualizarInfoCompra(String detallesCompra) {
        texto = detallesCompra;
    }
}
