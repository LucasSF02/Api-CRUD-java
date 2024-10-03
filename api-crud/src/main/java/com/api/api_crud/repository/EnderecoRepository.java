package com.api.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.api_crud.model.Endereco;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
