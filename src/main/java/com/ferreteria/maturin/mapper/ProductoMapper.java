package com.ferreteria.maturin.mapper;

import com.ferreteria.maturin.dto.ProductoDTO;
import com.ferreteria.maturin.entity.Producto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductoMapper {
    @Mapping(source = "categoriaId", target = "categoria.id")
    @Mapping(source = "proveedorId", target = "proveedor.id")
    @Mapping(source = "productoId", target =  "id")
    Producto toEntity(ProductoDTO productoDTO);

    @Mapping(target = "categoriaId", source = "categoria.id")
    @Mapping(target = "proveedorId", source = "proveedor.id")
    @Mapping(target = "productoId", source =  "id")
    ProductoDTO toDto(Producto producto);
}
