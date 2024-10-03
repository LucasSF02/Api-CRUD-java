package com.api.api_crud.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import com.api.api_crud.model.Produto;


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
