package com.fatec.apiDemo.entities;

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
    private Categoria cat_prod;

    public Produto() {}

    public Produto(String nome_prod, String descricao, double preco, boolean disponivel, Categoria cat_prod) {
        this.nome_prod = nome_prod;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
        this.cat_prod = cat_prod;
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
