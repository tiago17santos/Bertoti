package com.fatec.apiDemo.services;

import com.fatec.apiDemo.entities.Produto;
import com.fatec.apiDemo.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Transactional
    public void salvar(Produto produto) {
        Produto prod = new Produto();

        prod.setNome(produto.getNome());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setImgUrl(produto.getImgUrl());

        produtoRepository.save(prod);
    }

    @Transactional
    public List<Produto> buscarTodos(){
        return produtoRepository.findAll();
    }

    @Transactional
    public Optional<Produto> buscarPorId(Long id) {
        return produtoRepository.findById(id);
    }

    @Transactional
    public Produto atualizar(Long id, Produto produto) {
        Produto prod = produtoRepository.findById(id).get();
        prod.setNome(produto.getNome());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setImgUrl(produto.getImgUrl());
        produtoRepository.save(prod);
        return prod;
    }

    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }


}
