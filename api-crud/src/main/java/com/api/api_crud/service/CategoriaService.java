package com.api.api_crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api_crud.model.Categoria;
import com.api.api_crud.model.exception.ResourceBadRequestException;
import com.api.api_crud.model.exception.ResourceNotFoundException;
import com.api.api_crud.repository.CategoriaRepository;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    public Categoria adicionar(Categoria categoria) {
        if (categoria.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        categoria.setId((long) 0);
        return categoriaRepository.save(categoria);
    }
    
    public List<Categoria> obterTodos() {
        return categoriaRepository.findAll();
    }
    
    public Optional<Categoria> obterPorId(Long id) {
        Optional<Categoria> categoriaLocalizado = categoriaRepository.findById(id);

        if (categoriaLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um categoria com o id: " + id);
        }
        return categoriaLocalizado;

    }
    
    public Categoria atualizar(Long id, Categoria categoria) {

        obterPorId(id);
        categoria.setId(id);
        
        if (categoria.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        return categoriaRepository.save(categoria);
    }
    
    public void deletar(Long id) {

        obterPorId(id);
        categoriaRepository.deleteById(id);
    }

}
