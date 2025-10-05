package control;

import dtos.ProductoSeleccionadoDTO;
import modelo.IModeloControl;
import modelo.ModeloControlImp;

/**
 * Clase controladora que gestiona la lógica para la selección, compra y pago de
 * productos. Implementa el patrón Singleton para garantizar una única instancia
 * global. Actúa como punto de entrada para las operaciones relacionadas con la
 * compra.
 *
 * @author Alicia Denise García Acosta 00000252402
 */
public class ControlComprarProducto {

    /**
     * Instancia única (Singleton) de la clase ControlComprarProducto.
     */
    private static ControlComprarProducto instance;

    /**
     * Referencia a la interfaz de control de la capa de negocio, usada para
     * delegar las operaciones.
     */
    private IModeloControl modeloControl = ModeloControlImp.getInstance();

    /**
     * Constructor privado para prevenir la instanciación externa (patrón
     * Singleton).
     */
    private ControlComprarProducto() {
    }

    /**
     * Obtiene la instancia única de la clase ControlComprarProducto.
     *
     * @return La instancia de ControlComprarProducto.
     */
    public static ControlComprarProducto getInstance() {
        if (instance == null) {
            instance = new ControlComprarProducto();
        }
        return instance;
    }

    /**
     * Delega al modelo la acción de seleccionar o agregar un producto al
     * carrito de compra.
     *
     * @param productoSeleccionado DTO que contiene la información del producto
     * y la cantidad deseada.
     */
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        modeloControl.seleccionarProducto(productoSeleccionado);
    }

    /**
     * Delega al modelo la acción de procesar el pago de los productos
     * seleccionados.
     */
    public void pagarProductos() {
        modeloControl.pagarProductos();
    }

    /**
     * Delega al modelo la acción de validar la tarjeta de crédito o débito
     * proporcionada.
     *
     * @param numeroTarjeta El número de tarjeta a validar.
     */
    public void validarTarjeta(String numeroTarjeta) {
        modeloControl.validarTarjeta(numeroTarjeta);
    }
}
