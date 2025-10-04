/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author Alici
 */
public interface IModeloControl {
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado);

    public void validarTarjeta(String numeroTarjeta);

    public void pagarProductos();
}
