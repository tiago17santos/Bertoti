package com.fatec.apiProdutos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PageController {


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
}
