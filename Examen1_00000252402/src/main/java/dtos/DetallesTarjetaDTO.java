/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dtos;

/**
 *
 * @author Alici
 */
public class DetallesTarjetaDTO {

    private String numeroTarjeta;
    private String bancoEmisor;
    private String ciudadEmisor;

    public DetallesTarjetaDTO() {
    }

    public DetallesTarjetaDTO(String numeroTarjeta, String bancoEmisor, String ciudadEmisor) {
        this.numeroTarjeta = numeroTarjeta;
        this.bancoEmisor = bancoEmisor;
        this.ciudadEmisor = ciudadEmisor;
    }

    public String getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(String numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getBancoEmisor() {
        return bancoEmisor;
    }

    public void setBancoEmisor(String bancoEmisor) {
        this.bancoEmisor = bancoEmisor;
    }

    public String getCiudadEmisor() {
        return ciudadEmisor;
    }

    public void setCiudadEmisor(String ciudadEmisor) {
        this.ciudadEmisor = ciudadEmisor;
    }

}
