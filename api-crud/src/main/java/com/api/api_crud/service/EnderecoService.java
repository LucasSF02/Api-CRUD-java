package com.api.api_crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api_crud.model.Endereco;
import com.api.api_crud.model.exception.ResourceBadRequestException;
import com.api.api_crud.model.exception.ResourceNotFoundException;
import com.api.api_crud.repository.EnderecoRepository;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    public Endereco adicionar(Endereco endereco) {
        if (endereco.getCep().equals("")) {
            throw new ResourceBadRequestException("Cep não pode ser vazio");
        }
        endereco.setId((long) 0);
        return enderecoRepository.save(endereco);
    }
    
    public List<Endereco> obterTodos() {
        return enderecoRepository.findAll();
    }
    
    public Optional<Endereco> obterPorId(Long id) {
        Optional<Endereco> enderecoLocalizado = enderecoRepository.findById(id);

        if (enderecoLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um endereco com o id: " + id);
        }
        return enderecoLocalizado;

    }
    
    public Endereco atualizar(Long id, Endereco endereco) {

        obterPorId(id);
        endereco.setId(id);
        
        if (endereco.getCep().equals("")) {
            throw new ResourceBadRequestException("Cep não pode ser vazio");
        }
        return enderecoRepository.save(endereco);
    }
    
    public void deletar(Long id) {

        obterPorId(id);
        enderecoRepository.deleteById(id);
    }

}
