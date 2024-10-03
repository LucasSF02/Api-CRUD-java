package com.api.api_crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.api.api_crud.model.Produto;
import com.api.api_crud.model.exception.ResourceBadRequestException;
import com.api.api_crud.model.exception.ResourceNotFoundException;
import com.api.api_crud.repository.ProdutoRepository;

@Service
public class ProdutoService {
    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto adicionar(Produto produto) {
        if (produto.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        produto.setId((long) 0);
        return produtoRepository.save(produto);
    }
    
    public List<Produto> obterTodos() {
        return produtoRepository.findAll();
    }
    
    public Optional<Produto> obterPorId(Long id) {
        Optional<Produto> produtoLocalizado = produtoRepository.findById(id);

        if (produtoLocalizado.isEmpty()) {
            throw new ResourceNotFoundException("Não foi possivel encontrar um produto com o id: " + id);
        }
        return produtoLocalizado;

    }
    
    public Produto atualizar(Long id, Produto produto) {

        obterPorId(id);
        produto.setId(id);
        
        if (produto.getNome().equals("")) {
            throw new ResourceBadRequestException("Nome não pode ser vazio");
        }
        return produtoRepository.save(produto);
    }
    
    public void deletar(Long id) {

        obterPorId(id);
        produtoRepository.deleteById(id);
    }
        
}
