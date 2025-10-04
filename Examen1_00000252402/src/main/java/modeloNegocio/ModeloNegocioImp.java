package modeloNegocio;

import dtos.ProductoSeleccionadoDTO;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alici
 */
public class ModeloNegocioImp implements IModeloNegocio {

    private static ModeloNegocioImp instance;
    private List<BINInfo> binInfo;
    private Map<NegocioProducto, Integer> productosSeleccionados;

    private ModeloNegocioImp() {
    }

    public static ModeloNegocioImp getInstance() {
        if (instance == null) {
            instance = new ModeloNegocioImp();
        }
        return instance;
    }

    @Override
    public void obtenerInfoTarjeta(String numeroTarjeta) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void pagarCompra() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void agregarProducto(NegocioProducto producto) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
