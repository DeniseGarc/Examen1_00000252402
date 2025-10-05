package modelo;

import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import java.util.List;

/**
 * Interfaz que define las operaciones de solo lectura para que la capa de vista
 * (View) pueda consultar el estado actual de los datos del modelo.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public interface IModeloVista {

    /**
     * Obtiene la lista completa de productos disponibles en el catálogo.
     *
     * @return Una lista de DTOs con la información de los productos.
     */
    public List<ProductoDTO> obtenerProductos();

    /**
     * Obtiene la lista actual de productos que el usuario ha seleccionado para
     * la compra.
     *
     * @return Una lista de DTOs de los productos seleccionados con sus
     * cantidades y subtotales.
     */
    public List<ProductoSeleccionadoDTO> obtenerProductosSeleccionados();

    /**
     * Obtiene los detalles de la compra o la información de la tarjeta en
     * formato de texto para ser mostrados en la interfaz.
     *
     * @return El texto con los detalles (recibo de compra o detalles de
     * tarjeta).
     */
    public String obtenerDetalles();

    /**
     * Obtiene el estado de validez de la tarjeta de crédito/débito ingresada.
     *
     * @return true si la tarjeta es válida y fue procesada, false en caso
     * contrario.
     */
    public boolean obtenerValidezTarjeta();

    /**
     * Calcula y obtiene el monto total de todos los productos seleccionados en
     * el carrito.
     *
     * @return El costo total de la compra actual.
     */
    public double obtenerTotalProductos();
}
