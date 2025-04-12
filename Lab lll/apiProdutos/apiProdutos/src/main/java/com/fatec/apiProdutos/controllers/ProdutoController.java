package com.fatec.apiProdutos.controllers;

import com.fatec.apiProdutos.Dto.ProdutoDto;
import com.fatec.apiProdutos.entities.FiltroOpcao;
import com.fatec.apiProdutos.entities.Produto;
import com.fatec.apiProdutos.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<?> salvarProduto(@RequestBody ProdutoDto produto) {
        try {
            if(produto.categoriaId() == null){
                return ResponseEntity.notFound().build();
            }
            produto = produtoService.salvar(produto);
            return ResponseEntity.status(HttpStatus.CREATED).body(produto);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(Collections.singletonMap("error", "Erro ao criar produto: " + e.getMessage()));
        }

    }

    @GetMapping("/todos")
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> produtos = produtoService.buscarTodos();
        return ResponseEntity.ok().body(produtos);
    }


    @GetMapping
    public List<Produto> listarProdutos(@RequestParam(value = "opcao", required = false) FiltroOpcao opcao,
                                        @RequestParam(value = "drop_disp", required = false) String dropDisp,
                                        @RequestParam(value = "drop_cat", required = false) Long categoriaId) {
        return produtoService.filtrarProdutos(opcao, dropDisp, categoriaId);
    }


    /*@GetMapping
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
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id) {
        ProdutoDto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
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
