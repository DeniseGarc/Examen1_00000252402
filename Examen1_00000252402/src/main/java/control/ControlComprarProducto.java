/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import dtos.ProductoSeleccionadoDTO;
import modelo.IModeloControl;
import modelo.ModeloControlImp;

/**
 *
 * @author Alici
 */
public class ControlComprarProducto {

    private static ControlComprarProducto instance;
    private IModeloControl modeloControl = ModeloControlImp.getInstance();

    private ControlComprarProducto() {
    }

    public static ControlComprarProducto getInstance() {
        if (instance == null) {
            instance = new ControlComprarProducto();
        }
        return instance;
    }

    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        modeloControl.seleccionarProducto(productoSeleccionado);
    }

    public void pagarProductos() {
        modeloControl.pagarProductos();
    }

    public void validarTarjeta(String numeroTarjeta) {
        modeloControl.validarTarjeta(numeroTarjeta);
    }
}
