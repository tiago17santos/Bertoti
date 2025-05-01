package com.fatec.apiProdutos.services;

import com.fatec.apiProdutos.Dto.ProdutoDto;
import com.fatec.apiProdutos.Dto.ProdutoListagemDto;
import com.fatec.apiProdutos.entities.Categoria;
import com.fatec.apiProdutos.entities.FiltroOpcao;
import com.fatec.apiProdutos.entities.Produto;
import com.fatec.apiProdutos.repositories.CategoriaRepository;
import com.fatec.apiProdutos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CategoriaRepository categoriaRepository;

    @Transactional
    public ProdutoDto salvar(ProdutoDto produto) {
        Produto prod = new Produto();


        prod.setNomeProd(produto.nome());
        prod.setDescricao(produto.descricao());
        prod.setPreco(produto.preco());
        prod.setDisponivel(produto.disponivel());

        if (produto.categoriaId() == null) {
            throw new NoSuchElementException("Id nulo");
        }
        Categoria cat = new Categoria();
        cat.setId(produto.categoriaId());
        prod.setCategoria(cat);

        prod = produtoRepository.save(prod);

        return converteEmDto(prod);
    }

    public List<ProdutoListagemDto> filtrarProdutos(FiltroOpcao opcao, String dropDisp, Long categoriaId) {
        List<Produto> produtos;


        if (opcao != null) {
            switch (opcao) {
                case Disponivel:
                    boolean disponivel = "sim".equalsIgnoreCase(dropDisp);
                    produtos = produtoRepository.findByDisponivel(disponivel);
                    System.out.println(dropDisp);
                    break;
                case Categoria:
                    if (categoriaId != null) {
                        produtos = produtoRepository.findCategoriaById(categoriaId);
                    } else {
                        produtos = produtoRepository.findAll(); // Se categoriaId for nulo, retorna todos
                    }
                    break;
                default:
                    produtos = produtoRepository.findAll();
                    break;
            }
        } else {
            produtos = produtoRepository.findAll();
        }

        return produtos.stream()
                .map(this::converteParaDto)
                .collect(Collectors.toList());
    }



    @Transactional
    public List<ProdutoDto> buscarTodos(){
        List<Produto> prod = produtoRepository.findAll();
        return prod.stream().map(this::converteEmDto).collect(Collectors.toList());
    }

    @Transactional
    public ProdutoDto buscarPorId(Long id) {
        Produto produto = produtoRepository.findById(id).orElse(null);
        return converteEmDto(produto);
    }

    @Transactional
    public ProdutoDto atualizar(Long id, Produto produto) {
        Produto prod = produtoRepository.findById(id).get();


        prod.setNomeProd(produto.getNomeProd());
        prod.setDescricao(produto.getDescricao());
        prod.setPreco(produto.getPreco());
        prod.setDisponivel(produto.isDisponivel());
        produtoRepository.save(prod);

        return converteEmDto(prod);
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

    private ProdutoListagemDto converteParaDto(Produto produto){
        return new ProdutoListagemDto(
                produto.getId(),
                produto.getNomeProd(),
                produto.getDescricao(),
                produto.getPreco(),
                produto.isDisponivel(),
                produto.getCategoria().getNomeCat()
        );
    }
}
