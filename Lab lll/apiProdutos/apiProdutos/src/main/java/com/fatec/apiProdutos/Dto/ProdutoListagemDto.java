package com.fatec.apiProdutos.Dto;

public record ProdutoListagemDto (Long id, String nome, String descricao, double preco, boolean disponivel, String categoriaNome) {
}
