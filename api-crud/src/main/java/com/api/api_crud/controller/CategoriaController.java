package com.api.api_crud.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.api.api_crud.model.Categoria;
import com.api.api_crud.service.CategoriaService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/categorias")
public class CategoriaController {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> adicionar(@RequestBody Categoria categoria) {
        var categoriaCriado = categoriaService.adicionar(categoria);
        return new ResponseEntity<>(categoriaCriado, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> obterTodos() {
        return ResponseEntity.ok(categoriaService.obterTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Optional<Categoria>> obterPorId(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.obterPorId(id));

    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return ResponseEntity.ok(categoriaService.atualizar(id, categoria));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        categoriaService.deletar(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }

}
