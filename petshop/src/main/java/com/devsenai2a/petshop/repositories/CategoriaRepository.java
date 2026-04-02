package com.devsenai2a.petshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.devsenai2a.petshop.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}