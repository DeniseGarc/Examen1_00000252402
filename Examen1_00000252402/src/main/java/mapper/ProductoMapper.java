package mapper;

import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import modelo.Producto;
import modelo.ProductoSeleccionado;
import modeloNegocio.NegocioProducto;

public class ProductoMapper {

    public static ProductoDTO toDTO(NegocioProducto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setCosto(producto.getCosto());
        return dto;
    }

    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCosto(dto.getCosto());
        return producto;
    }

    public static ProductoDTO toProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setCosto(producto.getCosto());
        return dto;
    }

    public static ProductoSeleccionadoDTO toProductoSeleccionadoDTO(ProductoSeleccionado producto) {
        if (producto == null) {
            return null;
        }
        ProductoSeleccionadoDTO dto = new ProductoSeleccionadoDTO();
        dto.setNombre(producto.getProducto().getNombre());
        dto.setCantidad(producto.getCantidad());
        dto.setSubtotal(producto.getSubtotal());
        return dto;
    }
}