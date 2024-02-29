package com.ferreteria.maturin.repository;

import com.ferreteria.maturin.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto, Long> {
}
