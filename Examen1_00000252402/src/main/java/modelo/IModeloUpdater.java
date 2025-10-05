package modelo;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import java.util.List;

/**
 * Interfaz utilizada por la capa de Negocio para notificar actualizaciones de
 * estado a la fachada del modelo-vista (ModelVistaFacade), que a su vez
 * notifica a las vistas.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public interface IModeloUpdater {

    /**
     * Notifica la adición de un nuevo producto al catálogo y actualiza las
     * vistas.
     *
     * @param producto El DTO del producto que ha sido agregado.
     */
    public void agregarProducto(ProductoDTO producto);

    /**
     * Notifica y actualiza la información de la tarjeta de crédito/débito
     * después de una validación.
     *
     * @param detallesTarjeta El DTO que contiene el número de tarjeta y
     * detalles del emisor.
     */
    public void actualizarDatosTarjeta(DetallesTarjetaDTO detallesTarjeta);

    /**
     * Notifica y actualiza la lista de productos que el usuario ha seleccionado
     * para la compra.
     *
     * @param productosSeleccionados La lista de DTOs de los productos
     * seleccionados.
     */
    public void actualizarProductosSeleccionados(List<ProductoSeleccionadoDTO> productosSeleccionados);

    /**
     * Notifica la finalización de la compra y proporciona el resumen final de
     * la transacción.
     *
     * @param infoCompra El DTO que contiene el resumen de la compra, incluyendo
     * el total.
     */
    public void pagarProductos(InfoCompraDTO infoCompra);
}
