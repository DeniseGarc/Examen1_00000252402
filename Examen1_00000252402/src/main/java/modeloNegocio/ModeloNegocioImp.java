package modeloNegocio;

import dtos.DetallesTarjetaDTO;
import dtos.InfoCompraDTO;
import dtos.ProductoSeleccionadoDTO;
import modelo.IModeloUpdater;
import modelo.ModelVistaFacade;
import mapper.ProductoMapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Alici
 */
public class ModeloNegocioImp implements IModeloNegocio {

    private static ModeloNegocioImp instance;
    private IModeloUpdater modeloUpdater = ModelVistaFacade.getInstance();
    private List<BINInfo> binInfo = new ArrayList<>();
    private Map<NegocioProducto, Integer> productosSeleccionados = new HashMap<>();
    private List<NegocioProducto> productos = new ArrayList<>();

    private ModeloNegocioImp() {
    }

    public static ModeloNegocioImp getInstance() {
        if (instance == null) {
            instance = new ModeloNegocioImp();
        }
        return instance;
    }

    public void setBinInfo(List<BINInfo> binInfo) {
        this.binInfo = binInfo;
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
            tarjeta.setNumeroTarjeta("BIN no encontrado");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        } else {
            tarjeta.setNumeroTarjeta("Número de tarjeta inválido");
            modeloUpdater.actualizarDatosTarjeta(tarjeta);
        }
    }

    @Override
    public void seleccionarProducto(ProductoSeleccionadoDTO productoDTO) {

        NegocioProducto negocioProducto = null;
        int cantidadNueva = productoDTO.getCantidad();
        for (NegocioProducto productoCatalogo : productos) {
            if (productoDTO.getNombre().equals(productoCatalogo.getNombre())) {
                negocioProducto = productoCatalogo;
                break;
            }
        }
        if (productosSeleccionados.containsKey(negocioProducto)) {
            int cantidadAnterior = productosSeleccionados.get(negocioProducto);
            int cantidadTotal = cantidadAnterior + cantidadNueva;
            productosSeleccionados.put(negocioProducto, cantidadTotal);
        } else {
            productosSeleccionados.put(negocioProducto, cantidadNueva);
        }

        List<ProductoSeleccionadoDTO> seleccionaActualizada = new ArrayList<>();

        for (Map.Entry<NegocioProducto, Integer> entry : productosSeleccionados.entrySet()) {
            ProductoSeleccionadoDTO dto = new ProductoSeleccionadoDTO();
            NegocioProducto producto = entry.getKey();
            int cantidad = entry.getValue();
            dto.setNombre(producto.getNombre());
            dto.setCantidad(cantidad);
            dto.setSubtotal(producto.getCosto() * cantidad);
            seleccionaActualizada.add(dto);
        }
        modeloUpdater.actualizarProductosSeleccionados(seleccionaActualizada);
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
