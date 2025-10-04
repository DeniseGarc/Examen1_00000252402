package mapper;

import dtos.ProductoDTO;
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
}