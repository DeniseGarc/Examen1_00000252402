/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IModeloUpdater {

    public void agregarProducto(ProductoDTO producto);

    public void actualizarDatosTarjeta(DetallesTarjetaDTO detallesTarjeta);

    public void actualizarProductosSeleccionados(List<ProductoSeleccionadoDTO> productosSeleccionados);

    public void pagarProductos(InfoCompraDTO infoCompra);
}
