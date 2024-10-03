package com.api.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.api_crud.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
