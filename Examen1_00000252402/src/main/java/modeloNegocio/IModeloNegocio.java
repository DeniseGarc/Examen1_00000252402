package modeloNegocio;

import dtos.ProductoSeleccionadoDTO;

/**
 * Interfaz que define las operaciones disponibles en la capa de lógica de
 * negocio. Esta interfaz desacopla la implementación de la lógica de negocio de
 * las capas superiores (control y presentación).
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public interface IModeloNegocio {

    /**
     * Intenta obtener información detallada de una tarjeta de crédito o débito
     * a partir de su número.
     *
     * @param numeroTarjeta El número de tarjeta (BIN) a validar.
     */
    public void obtenerInfoTarjeta(String numeroTarjeta);

    /**
     * Agrega o actualiza la cantidad de un producto seleccionado en el carrito
     * de compras.
     *
     * @param producto El ProductoSeleccionadoDTO con el nombre y la cantidad a
     * seleccionar.
     */
    public void seleccionarProducto(ProductoSeleccionadoDTO producto);

    /**
     * Ejecuta el proceso de pago final de los productos seleccionados en el
     * carrito. Una vez completado, vacía la selección actual.
     */
    public void pagarCompra();

    /**
     * Agrega un nuevo producto al catálogo disponible en la aplicación.
     *
     * @param producto El modelo de negocio del producto a agregar.
     */
    public void agregarProducto(NegocioProducto producto);
}
