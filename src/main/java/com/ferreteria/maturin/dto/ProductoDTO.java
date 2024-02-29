package com.ferreteria.maturin.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoDTO {
    private Long productoId;
    private String nombre;
    private String descripcion;
    private Double precioCompra;
    private Double precioVenta;
    private Integer stock;
    private Long categoriaId;
    private Long proveedorId;

}
