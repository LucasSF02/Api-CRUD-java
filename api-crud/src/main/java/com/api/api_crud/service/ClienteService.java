package com.api.api_crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api_crud.model.Cliente;
import com.api.api_crud.model.exception.ResourceBadRequestException;
import com.api.api_crud.model.exception.ResourceNotFoundException;
import com.api.api_crud.repository.ClienteRepository;

@Service
public class ClienteService {
    @Autowired
    private ClienteRepository clienteRepository;

    public Cliente adicionar(Cliente cliente) {
        if (cliente.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        cliente.setId((long) 0);
        return clienteRepository.save(cliente);
    }
    
    public List<Cliente> obterTodos() {
        return clienteRepository.findAll();
    }
    
    public Optional<Cliente> obterPorId(Long id) {
        Optional<Cliente> clienteLocalizado = clienteRepository.findById(id);

        if (clienteLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um cliente com o id: " + id);
        }
        return clienteLocalizado;

    }
    
    public Cliente atualizar(Long id, Cliente cliente) {

        obterPorId(id);
        cliente.setId(id);
        
        if (cliente.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        return clienteRepository.save(cliente);
    }
    
    public void deletar(Long id) {

        obterPorId(id);
        clienteRepository.deleteById(id);
    }

}
