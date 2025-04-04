package com.fatec.apiProdutos.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "tb_categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="nome_cat", length = 200, nullable = false)
    private String nomeCat;

    @OneToMany(mappedBy = "categoria") // Relacionamento bidirecional com Produto
    private List<Produto> produtos;

    public Categoria() {}

    public Categoria( String nomeCat) {
        this.nomeCat = nomeCat;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCat() {
        return nomeCat;
    }

    public void setNomeCat(String nomeCat) {
        this.nomeCat = nomeCat;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }


}
