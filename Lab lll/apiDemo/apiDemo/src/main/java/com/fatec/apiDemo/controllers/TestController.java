package com.fatec.apiDemo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {

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
