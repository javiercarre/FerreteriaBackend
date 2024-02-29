package com.ferreteria.maturin.service;

import com.ferreteria.maturin.dto.ProductoDTO;
import com.ferreteria.maturin.entity.Producto;
import com.ferreteria.maturin.exception.RecursoNoEncontradoException;
import com.ferreteria.maturin.mapper.ProductoMapper;
import com.ferreteria.maturin.repository.CategoriaRepository;
import com.ferreteria.maturin.repository.ProductoRepository;
import com.ferreteria.maturin.repository.ProveedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductoService {
    @Autowired
    private ProductoRepository productoRepository;

    @Autowired
    private ProveedorRepository proveedorRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Autowired
    private ProductoMapper productoMapper;

    public List<ProductoDTO> listarTodos() {
        return productoRepository.findAll().stream()
                .map(productoMapper::toDto)
                .collect(Collectors.toList());
    }

    public Optional<ProductoDTO> buscarPorId(Long id) {
        return productoRepository.findById(id)
                .map(productoMapper::toDto);
    }

    public ProductoDTO guardar(ProductoDTO productoDTO) {
        boolean existeCategoria = categoriaRepository.existsById(productoDTO.getCategoriaId());
        if (!existeCategoria) {
            throw new RecursoNoEncontradoException("Categoría no encontrada con ID: " + productoDTO.getCategoriaId());
        }
        boolean existeProveedor = proveedorRepository.existsById(productoDTO.getProveedorId());
        if (!existeProveedor) {
            throw new RecursoNoEncontradoException("Proveedor no encontrado con ID: " + productoDTO.getProveedorId());
        }
        Producto producto = productoMapper.toEntity(productoDTO);
        producto = productoRepository.save(producto);
        return productoMapper.toDto(producto);
    }

    public ProductoDTO actualizar(Long id, ProductoDTO productoDTO) {
        if (!productoRepository.existsById(id)) {
            throw new RecursoNoEncontradoException("Producto no encontrado con ID: " + id);
        }
        Producto producto = productoMapper.toEntity(productoDTO);
        producto.setId(id);
        producto = productoRepository.save(producto);
        return productoMapper.toDto(producto);
    }

    public void eliminar(Long id) {
        productoRepository.deleteById(id);
    }
}
