package modeloNegocio;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoSeleccionadoDTO;
import modelo.IModeloUpdater;
import modelo.ModelVistaFacade;
import mapper.ProductoMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alici
 */
public class ModeloNegocioImp implements IModeloNegocio {

    private static ModeloNegocioImp instance;
    private IModeloUpdater modeloUpdater = ModelVistaFacade.getInstance();
    private List<BINInfo> binInfo;
    private Map<NegocioProducto, Integer> productosSeleccionados;
    private List<NegocioProducto> productos;

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
        DetallesTarjetaDTO tarjeta = new DetallesTarjetaDTO();

        if (numeroTarjeta.trim().isEmpty()) {
            return;
        }

        if (numeroTarjeta.trim().matches("\\d{16}")) {
            String bin = numeroTarjeta.substring(0, 6);
            for (BINInfo info : binInfo) {
                if (info.getPrefijoBIN().equals(bin)) {
                    tarjeta.setBancoEmisor(info.getBancoEmisor());
                    tarjeta.setCiudadEmisor(info.getCiudadEmisor());
                    tarjeta.setNumeroTarjeta(numeroTarjeta);
                    modeloUpdater.actualizarDatosTarjeta(tarjeta);
                    return;
                }
            }
            tarjeta.setNumeroTarjeta("BIN no encontrado.");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        } else {
            tarjeta.setNumeroTarjeta("Número de tarjeta inválido");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        }
    }

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO producto) {
        for (NegocioProducto negocioProducto : productos) {
            if (negocioProducto.getNombre().equals(producto.getNombre())) {
                productosSeleccionados.put(negocioProducto, producto.getCantidad());
                producto.setSubtotal(negocioProducto.getCosto() * producto.getCantidad());
                modeloUpdater.seleccionarProducto(producto);
                break;
            }
        }

    }

    @Override
    public void pagarCompra() {
        double total = 0;
        List<ProductoSeleccionadoDTO> productosDTO = new ArrayList<>();
        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            total += entry.getKey().getCosto() * entry.getValue();
        }

        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            ProductoSeleccionadoDTO dto = new ProductoSeleccionadoDTO();
            dto.setNombre(entry.getKey().getNombre());
            dto.setCantidad(entry.getValue());
            dto.setSubtotal(entry.getKey().getCosto() * entry.getValue());
            productosDTO.add(dto);
        }

        InfoCompraDTO infoCompra = new InfoCompraDTO(productosDTO, total, null);
        modeloUpdater.pagarProductos(infoCompra);
        productosSeleccionados.clear();
    }

    @Override
    public void agregarProducto(NegocioProducto producto) {
        productos.add(producto);
        modeloUpdater.agregarProducto(ProductoMapper.toDTO(producto));
    }

}
