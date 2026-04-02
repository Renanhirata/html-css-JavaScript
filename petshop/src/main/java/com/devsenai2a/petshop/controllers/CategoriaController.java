package com.devsenai2a.petshop.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.devsenai2a.petshop.entities.Categoria;
import com.devsenai2a.petshop.services.CategoriaService;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping
    public List<Categoria> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Categoria buscar(@PathVariable Long id) {
        return service.buscarPorId(id);
    }

    @PostMapping
    public Categoria criar(@RequestBody Categoria categoria) {
        return service.criar(categoria);
    }

    @PutMapping("/{id}")
    public Categoria atualizar(@PathVariable Long id, @RequestBody Categoria categoria) {
        return service.atualizar(id, categoria);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}