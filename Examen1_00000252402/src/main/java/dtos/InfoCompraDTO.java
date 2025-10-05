package dtos;

import java.util.List;

/**
 * Clase DTO (Data Transfer Object) que encapsula la información completa de una
 * compra. Incluye la lista de productos seleccionados, el monto total de la
 * compra, y los detalles de la tarjeta utilizada para el pago.
 *
 * @author Alicia Denise Garcia Acosta 00000252402
 *
 */
public class InfoCompraDTO {

    /**
     * Lista de productos que forman parte de la compra. Cada elemento es de
     * tipo ProductoSeleccionadoDTO.
     */
    private List<ProductoSeleccionadoDTO> productos;

    /**
     * El monto total de la compra.
     */
    private double total;

    /**
     * Los detalles de la tarjeta utilizada para procesar el pago.
     */
    private DetallesTarjetaDTO detallesTarjeta;

    /**
     * Constructor por defecto (sin argumentos) de la clase InfoCompraDTO.
     */
    public InfoCompraDTO() {
    }

    /**
     * Constructor que inicializa todos los atributos de la clase.
     *
     * @param productos Lista de productos seleccionados para la compra.
     * @param total El monto total de la compra.
     * @param detallesTarjeta Los detalles de la tarjeta utilizada para la
     * transacción.
     */
    public InfoCompraDTO(List<ProductoSeleccionadoDTO> productos, double total, DetallesTarjetaDTO detallesTarjeta) {
        this.productos = productos;
        this.total = total;
        this.detallesTarjeta = detallesTarjeta;
    }

    /**
     * Obtiene la lista de productos seleccionados.
     *
     * @return La lista de {@link ProductoSeleccionadoDTO}.
     */
    public List<ProductoSeleccionadoDTO> getProductos() {
        return productos;
    }

    /**
     * Establece o actualiza la lista de productos seleccionados.
     *
     * @param productos La nueva lista de productos a establecer.
     */
    public void setProductos(List<ProductoSeleccionadoDTO> productos) {
        this.productos = productos;
    }

    /**
     * Obtiene el monto total de la compra.
     *
     * @return El monto total.
     */
    public double getTotal() {
        return total;
    }

    /**
     * Establece o actualiza el monto total de la compra.
     *
     * @param total El nuevo monto total a establecer.
     */
    public void setTotal(double total) {
        this.total = total;
    }

    /**
     * Obtiene los detalles de la tarjeta utilizados para el pago.
     *
     * @return El objeto {@link DetallesTarjetaDTO} con los detalles.
     */
    public DetallesTarjetaDTO getDetallesTarjeta() {
        return detallesTarjeta;
    }

    /**
     * Establece o actualiza los detalles de la tarjeta.
     *
     * @param detallesTarjeta Los nuevos detalles de la tarjeta a establecer.
     */
    public void setDetallesTarjeta(DetallesTarjetaDTO detallesTarjeta) {
        this.detallesTarjeta = detallesTarjeta;
    }

}
