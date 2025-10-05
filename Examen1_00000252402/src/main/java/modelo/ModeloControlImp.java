package modelo;

import dtos.ProductoSeleccionadoDTO;
import modeloNegocio.IModeloNegocio;
import modeloNegocio.ModeloNegocioImp;

/**
 * Clase que implementa la interfaz IModeloControl. Actúa como la capa de
 * control que recibe las peticiones de la vista y las delega a la capa de
 * negocio (IModeloNegocio). Implementa el patrón **Singleton**.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ModeloControlImp implements IModeloControl {

    /**
     * Instancia única (Singleton) de la clase ModeloControlImp.
     */
    private static ModeloControlImp instance;

    /**
     * Referencia a la capa de negocio para la delegación de operaciones.
     */
    private IModeloNegocio modeloNegocio = ModeloNegocioImp.getInstance();

    /**
     * Constructor privado para forzar el uso del patrón Singleton.
     */
    private ModeloControlImp() {
    }

    /**
     * Obtiene la instancia única de la clase ModeloControlImp (patrón
     * Singleton).
     *
     * @return La instancia única de ModeloControlImp.
     */
    public static ModeloControlImp getInstance() {
        if (instance == null) {
            instance = new ModeloControlImp();
        }
        return instance;
    }

    /**
     * Delega la selección de un producto al modelo de negocio.
     *
     * @param productoSeleccionado DTO que contiene el producto y la cantidad
     * seleccionada.
     */
    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoSeleccionado) {
        modeloNegocio.seleccionarProducto(productoSeleccionado);
    }

    /**
     * Delega la solicitud de validación y obtención de información de una
     * tarjeta al modelo de negocio.
     *
     * @param numeroTarjeta El número de tarjeta a validar.
     */
    @Override
    public void validarTarjeta(String numeroTarjeta) {
        modeloNegocio.obtenerInfoTarjeta(numeroTarjeta);
    }

    /**
     * Delega la acción de pagar los productos seleccionados al modelo de
     * negocio.
     */
    @Override
    public void pagarProductos() {
        modeloNegocio.pagarCompra();
    }

}
