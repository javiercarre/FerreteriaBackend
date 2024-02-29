package com.ferreteria.maturin.repository;

import com.ferreteria.maturin.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
