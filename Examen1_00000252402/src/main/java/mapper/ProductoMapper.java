package mapper;

import dtos.ProductoDTO;
import dtos.ProductoSeleccionadoDTO;
import modelo.Producto;
import modelo.ProductoSeleccionado;
import modeloNegocio.NegocioProducto;

/**
 * Clase de utilidad (Mapper) encargada de la conversión entre los objetos de
 * transferencia de datos (DTOs) relacionados con productos y sus
 * correspondientes entidades de negocio o persistencia. Los métodos son
 * estáticos para facilitar su uso.
 *
 * @author Alicia Denise García Acosta 00000252402
 *
 */
public class ProductoMapper {

    /**
     * Convierte un objeto de modelo de negocio NegocioProducto a un DTO de
     * producto.
     *
     * @param producto El objeto NegocioProducto a convertir.
     * @return Un objeto ProductoDTO si la entrada no es nula; de lo contrario,
     * retorna null.
     */
    public static ProductoDTO toDTO(NegocioProducto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setCosto(producto.getCosto());
        return dto;
    }

    /**
     * Convierte un objeto de transferencia de datos ProductoDTO a una entidad
     * de persistencia Producto.
     *
     * @param dto El objeto ProductoDTO a convertir.
     * @return Una entidad Producto si la entrada no es nula; de lo contrario,
     * retorna null.
     */
    public static Producto toEntity(ProductoDTO dto) {
        if (dto == null) {
            return null;
        }
        Producto producto = new Producto();
        producto.setNombre(dto.getNombre());
        producto.setCosto(dto.getCosto());
        return producto;
    }

    /**
     * Convierte una entidad de persistencia Producto a un DTO de producto.
     *
     * @param producto La entidad Producto a convertir.
     * @return Un objeto ProductoDTO si la entrada no es nula; de lo contrario,
     * retorna null.
     */
    public static ProductoDTO toProductoDTO(Producto producto) {
        if (producto == null) {
            return null;
        }
        ProductoDTO dto = new ProductoDTO();
        dto.setNombre(producto.getNombre());
        dto.setCosto(producto.getCosto());
        return dto;
    }

    /**
     * Convierte una entidad de producto seleccionado ProductoSeleccionado a su
     * DTO correspondiente.
     *
     * @param producto El objeto ProductoSeleccionado a convertir.
     * @return Un objeto ProductoSeleccionadoDTO si la entrada no es nula; de lo
     * contrario, retorna null.
     */
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
