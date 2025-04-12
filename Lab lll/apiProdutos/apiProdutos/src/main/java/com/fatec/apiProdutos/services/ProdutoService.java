package com.fatec.apiProdutos.services;

import com.fatec.apiProdutos.Dto.ProdutoDto;
import com.fatec.apiProdutos.entities.FiltroOpcao;
import com.fatec.apiProdutos.entities.Produto;
import com.fatec.apiProdutos.repositories.ProdutoRepository;
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
    public ProdutoDto salvar(ProdutoDto produto) {
        Produto prod = new Produto();

        prod.setNomeProd(produto.nome());
        prod.setDescricao(produto.descricao());
        prod.setPreco(produto.preco());
        prod.setDisponivel(produto.disponivel());


        prod = produtoRepository.save(prod);

        return converteEmDto(prod);
    }

    public List<Produto> filtrarProdutos(FiltroOpcao opcao, String dropDisp, Long categoriaId) {
        switch (opcao) {
            case Disponivel:
                boolean disponivel = "sim".equals(dropDisp);
                return produtoRepository.findByDisponivel(disponivel);
            case Categoria:
                if (categoriaId != null) {
                    return produtoRepository.findCategoriaById(categoriaId);
                }
                break;
        }
        return produtoRepository.findAll();
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


        prod.setNomeProd(produto.getNomeProd());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setDisponivel(produto.isDisponivel());
        produtoRepository.save(prod);
        return prod;
    }

    @Transactional
    public void deletar(Long id) {
        produtoRepository.deleteById(id);
    }


    private ProdutoDto converteEmDto(Produto produto){
        return new ProdutoDto(
                produto.getId(),
                produto.getNomeProd(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.isDisponivel(),
                produto.getCategoria().getId()
        );
    }
}
