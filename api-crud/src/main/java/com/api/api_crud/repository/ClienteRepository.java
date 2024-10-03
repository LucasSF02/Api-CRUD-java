package com.api.api_crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.api.api_crud.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
