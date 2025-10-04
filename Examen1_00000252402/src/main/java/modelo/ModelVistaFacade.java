/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author Alici
 */
public class ModelVistaFacade implements IModeloVista {

    private static ModelVistaFacade instance;
    private List<ProductoSubject> productos;
    private List<ProductoSeleccionadoSubject> productosSeleccionados;

    private ModelVistaFacade() {
    }

    public static ModelVistaFacade getInstance() {
        if (instance == null) {
            instance = new ModelVistaFacade();
        }
        return instance;
    }

    @Override
    public void agregarProducto(ProductoDTO producto) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'agregarProducto'");
    }

    @Override
    public void actualizarDatosTarjeta(DetallesTarjetaDTO detallesTarjeta) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarDatosTarjeta'");
    }

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'seleccionarProducto'");
    }

    @Override
    public void pagarProductos(InfoCompraDTO infoCompra) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'pagarProductos'");
    }

}
