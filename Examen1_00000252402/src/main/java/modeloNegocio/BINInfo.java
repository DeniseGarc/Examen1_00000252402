/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modeloNegocio;

/**
 *
 * @author Alici
 */
public class BINInfo {

    private String prefijoBIN;
    private String bancoEmisor;
    private String ciudadEmisor;

    public BINInfo() {
    }

    public BINInfo(String prefijoBIN, String bancoEmisor, String ciudadEmisor) {
        this.prefijoBIN = prefijoBIN;
        this.bancoEmisor = bancoEmisor;
        this.ciudadEmisor = ciudadEmisor;
    }

    public String getPrefijoBIN() {
        return prefijoBIN;
    }

    public void setPrefijoBIN(String prefijoBIN) {
        this.prefijoBIN = prefijoBIN;
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
