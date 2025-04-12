package com.fatec.apiProdutos.Dto;

public record ProdutoDto(Long id, String nome, String descricao, double preco, boolean disponivel, Long categoriaId) {
}
