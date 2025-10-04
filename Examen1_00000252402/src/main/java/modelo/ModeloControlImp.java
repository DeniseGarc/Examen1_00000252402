/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import dtos.ProductoSeleccionadoDTO;
import modeloNegocio.IModeloNegocio;
import modeloNegocio.ModeloNegocioImp;

/**
 *
 * @author Alici
 */
public class ModeloControlImp implements IModeloControl {

    private static ModeloControlImp instance;
    private IModeloNegocio modeloNegocio = ModeloNegocioImp.getInstance();

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
        modeloNegocio.seleccionarProducto(productoSeleccionado);
    }

    @Override
    public void validarTarjeta(String numeroTarjeta) {
        modeloNegocio.obtenerInfoTarjeta(numeroTarjeta);
    }

    @Override
    public void pagarProductos() {
        modeloNegocio.pagarCompra();
    }

}
