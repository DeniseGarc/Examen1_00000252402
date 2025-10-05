package modelo;

import dtos.ProductoSeleccionadoDTO;

/**
 * Interfaz que define el contrato de la capa de control del modelo. Actúa como
 * un puente entre la capa de presentación (vistas) y la capa de lógica de
 * negocio (IModeloNegocio).
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public interface IModeloControl {

    /**
     * Delega la acción de seleccionar o actualizar un producto en el carrito de
     * compras a la capa de negocio.
     *
     * @param productoSeleccionado El DTO con la información del producto y la
     * cantidad a seleccionar.
     */
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado);

    /**
     * Delega la solicitud de validación de una tarjeta a la capa de negocio
     * para obtener detalles del emisor.
     *
     * @param numeroTarjeta El número de tarjeta a validar.
     */
    public void validarTarjeta(String numeroTarjeta);

    /**
     * Delega la ejecución del proceso de pago de los productos seleccionados a
     * la capa de negocio.
     */
    public void pagarProductos();
}
