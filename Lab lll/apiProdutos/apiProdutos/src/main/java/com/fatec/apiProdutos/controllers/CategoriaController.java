package com.fatec.apiProdutos.controllers;

import com.fatec.apiProdutos.entities.Categoria;
import com.fatec.apiProdutos.repositories.CategoriaRepository;
import com.fatec.apiProdutos.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {

    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public Categoria cadastrarCategoria(@RequestBody Categoria categoria) {
        categoria = categoriaService.salvar(categoria);
        return categoria;
    }

    @GetMapping
    public List<Categoria> listarCategorias() {
        List<Categoria> cat = categoriaService.listarTodas();
        return cat;
    }
}
