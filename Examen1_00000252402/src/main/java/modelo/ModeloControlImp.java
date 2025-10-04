/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author Alici
 */
public class ModeloControlImp implements IModeloControl {

    private static ModeloControlImp instance;

    private ModeloControlImp() {
    }

    public static ModeloControlImp getInstance() {
        if (instance == null) {
            instance = new ModeloControlImp();
        }
        return instance;
    }

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seleccionarProducto'");
    }

    @Override
    public void validarTarjeta(String numeroTarjeta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'validarTarjeta'");
    }

    @Override
    public void pagarProductos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagarProductos'");
    }

}
