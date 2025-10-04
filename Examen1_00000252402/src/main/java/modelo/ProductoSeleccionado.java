/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Alici
 */
public class ProductoSeleccionado {

    private Producto producto;
    private double subtotal;
    private int cantidad;

    public ProductoSeleccionado() {
    }

    public ProductoSeleccionado(Producto producto, int cantidad, double subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = producto.getCosto() * cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
        actualizarSubtotal();
    }

    public double getSubtotal() {
        return subtotal;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        actualizarSubtotal();
    }

    private void actualizarSubtotal() {
        if (producto != null) {
            this.subtotal = producto.getCosto() * cantidad;
        } else {
            this.subtotal = 0;
        }
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

}
