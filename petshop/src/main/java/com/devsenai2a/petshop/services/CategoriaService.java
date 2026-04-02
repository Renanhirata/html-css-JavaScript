package com.devsenai2a.petshop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsenai2a.petshop.entities.Categoria;
import com.devsenai2a.petshop.repositories.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository repository;

    public Categoria criar(Categoria categoria) {
        return repository.save(categoria);
    }

    public List<Categoria> listar() {
        return repository.findAll();
    }

    public Categoria buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Categoria atualizar(Long id, Categoria novaCategoria) {
        Categoria categoria = repository.findById(id).orElse(null);

        if (categoria == null) {
            return null;
        }

        categoria.setNome(novaCategoria.getNome());
        categoria.setDescricao(novaCategoria.getDescricao());

        return repository.save(categoria);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}