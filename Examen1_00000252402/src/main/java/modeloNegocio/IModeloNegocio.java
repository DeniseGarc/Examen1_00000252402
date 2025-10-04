/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modeloNegocio;

import dtos.ProductoSeleccionadoDTO;

/**
 *
 * @author Alici
 */
public interface IModeloNegocio {

    public void obtenerInfoTarjeta(String numeroTarjeta);

    public void seleccionarProducto(ProductoSeleccionadoDTO producto);

    public void pagarCompra();

    public void agregarProducto(NegocioProducto producto);
}
