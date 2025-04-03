package com.fatec.apiDemo.controllers;

import com.fatec.apiDemo.entities.Produto;
import com.fatec.apiDemo.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<Produto> salvarProduto(@RequestBody Produto produto) {

        produtoService.salvar(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(produto);
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listar() {
        List<Produto> produtos = produtoService.buscarTodos();
        return ResponseEntity.ok().body(produtos);
    }
<<<<<<< HEAD
=======

    @GetMapping
    public List<Produto> listarProdutos(@RequestParam(value = "opcao", required = false) String opcao,
                                        @RequestParam(value = "drop_disp", required = false) String dropDisp,
                                        @RequestParam(value = "drop_cat", required = false) Long categoriaId) {
        return produtoService.filtrarProdutos(opcao, dropDisp, categoriaId);
    }


>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
    /*
    @GetMapping
    public String listarProdutos(@RequestParam(value = "opcao", required = false) String opcao,
                                 @RequestParam(value = "drop_disp", required = false) String dropDisp,
                                 @RequestParam(value = "drop_cat", required = false) Long categoriaId,
                                 Model model) {
        List<Produto> produtos = produtoService.filtrarProdutos(opcao, dropDisp, categoriaId);
        List<Categoria> categorias = produtoService.getAllCategorias();

        model.addAttribute("produtos", produtos);
        model.addAttribute("categorias", categorias);
        model.addAttribute("opcao", opcao);

        return "produtos/lista";
    }*/

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        Optional<Produto> produto = produtoService.buscarPorId(id);
        return produto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        Produto produtoAtual = produtoService.atualizar(id, produto);
        return ResponseEntity.ok().body(produtoAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
