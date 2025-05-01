package com.fatec.apiProdutos.controllers;

import com.fatec.apiProdutos.Dto.ProdutoDto;
import com.fatec.apiProdutos.entities.Produto;
import com.fatec.apiProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/cadastro")
    public String home() {
        return "cadastro";
    }

    @GetMapping("/categoria")
    public String categoria() {
        return "categoria";
    }

    @GetMapping("/listagem")
    public String listagem() {
        return "listagem";
    }

    @GetMapping("/editar_prod/{id}")
    public String editar_prod(@PathVariable Long id, Model model) {
        ProdutoDto produto = produtoService.buscarPorId(id); // ou produtoRepository.findById(id).get()
        model.addAttribute("produto", produto);
        return "editar_prod";
    }
}
