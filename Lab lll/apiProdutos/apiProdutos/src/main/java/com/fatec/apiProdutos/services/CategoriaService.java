package com.fatec.apiProdutos.services;

import com.fatec.apiProdutos.entities.Categoria;
import com.fatec.apiProdutos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public Categoria salvar(Categoria categoria) {
        categoria.setNomeCat(categoria.getNomeCat());
        return categoriaRepository.save(categoria);
    }

    @Transactional
    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }
}
