package com.fatec.apiProdutos.controllers;

import com.fatec.apiProdutos.Dto.CategoriaDto;
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
    public CategoriaDto cadastrarCategoria(@RequestBody CategoriaDto categoria) {
        categoria = categoriaService.salvar(categoria);
        return categoria;
    }

    @GetMapping
    public List<CategoriaDto> listarCategorias() {
        List<CategoriaDto> cat = categoriaService.listarTodas();
        return cat;
    }
}
