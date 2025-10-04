/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package modelo;

import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import java.util.List;

/**
 *
 * @author Alici
 */
public interface IModeloVista {

    public List<ProductoDTO> obtenerProductos();

    public List<ProductoSeleccionadoDTO> obtenerProductosSeleccionados();

    public String obtenerDetalles();

    public boolean obtenerValidezTarjeta();
}
