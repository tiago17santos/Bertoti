package com.fatec.apiProdutos.controllers;

import com.fatec.apiProdutos.Dto.CategoriaDto;
import com.fatec.apiProdutos.Dto.ProdutoDto;
import com.fatec.apiProdutos.Dto.ProdutoListagemDto;
import com.fatec.apiProdutos.entities.FiltroOpcao;
import com.fatec.apiProdutos.entities.Produto;
import com.fatec.apiProdutos.services.CategoriaService;
import com.fatec.apiProdutos.services.ProdutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private CategoriaService categoriaService;

    private static final Logger logger = LoggerFactory.getLogger(ProdutoController.class);


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

    @GetMapping
    public ResponseEntity<List<ProdutoDto>> listar() {
        List<ProdutoDto> produtos = produtoService.buscarTodos();
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<ProdutoListagemDto>> filtrarProdutos(
            @RequestParam(value = "drop_disp", required = false) String dropDisp,
            @RequestParam(value = "drop_cat", required = false) Long categoriaId) {

        List<ProdutoListagemDto> produtos = produtoService.filtrarProdutos(dropDisp, categoriaId);
        return ResponseEntity.ok().body(produtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoDto> buscarPorId(@PathVariable Long id) {
        ProdutoDto produto = produtoService.buscarPorId(id);
        return ResponseEntity.ok().body(produto);
    }

    @PutMapping("/editar_prod/{id}")
    public ResponseEntity<ProdutoDto> editarProduto(@PathVariable Long id, @RequestBody Produto produto) {
        ProdutoDto produtoAtual = produtoService.atualizar(id, produto);
        return ResponseEntity.ok().body(produtoAtual);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.ok().build();
    }

}
