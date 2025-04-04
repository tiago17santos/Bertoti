package com.fatec.apiProdutos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Table(name = "tb_produtos")
@Getter
@Setter
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome_prod", nullable = false)
    private String nome_prod;

    @Column(columnDefinition = "Text", nullable = false)
    private String descricao;

    @Column(name = "preco", nullable = false)
    private double preco;

    @Column(name = "disponivel")
    private boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoriaId;

    public Produto() {
    }

    public Produto(String nome_prod, String descricao, double preco, boolean disponivel, Categoria categoriaId) {
        this.nome_prod = nome_prod;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
        this.categoriaId = categoriaId;

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome_prod() {
        return nome_prod;
    }

    public void setNome_prod(String nome_prod) {
        this.nome_prod = nome_prod;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Produto produto = (Produto) o;
        return id == produto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
