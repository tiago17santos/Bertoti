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

<<<<<<< HEAD
<<<<<<< HEAD
=======
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
    public List<Produto> filtrarProdutos(String opcao, String dropDisp, Long categoriaId) {
        if ("Disponível".equals(opcao)) {
            // Filtra os produtos pela disponibilidade
            boolean disponivel = "sim".equals(dropDisp);
            return produtoRepository.findByDisponivel(disponivel);
        } else if ("Categoria".equals(opcao) && categoriaId != null) {
            // Filtra os produtos pela categoria
            return produtoRepository.findByCategoriaId(categoriaId);
        }
        // Caso não haja filtro, retorna todos os produtos
        return produtoRepository.findAll();
    }

<<<<<<< HEAD
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
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
<<<<<<< HEAD
<<<<<<< HEAD
        prod.setNome(produto.getNome());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setImgUrl(produto.getImgUrl());
=======
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
        prod.setNome_prod(produto.getNome_prod());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setDescricao(produto.getDescricao());
<<<<<<< HEAD
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
        produtoRepository.save(prod);
        return prod;
    }

    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }


}
