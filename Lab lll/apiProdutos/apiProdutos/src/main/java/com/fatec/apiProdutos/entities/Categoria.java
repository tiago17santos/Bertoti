package com.fatec.apiProdutos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
@Getter
@Setter
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome_cat", length = 200, nullable = false)
    private String nomeCat;

    @OneToMany(mappedBy = "categoria") // Relacionamento bidirecional com Produto
    private List<Produto> produtos;

    public Categoria() {}

    public Categoria(String nome) {
        this.nomeCat = nome;
    }
}
