package com.fatec.apiDemo.entities;

import jakarta.persistence.*;
<<<<<<< HEAD
<<<<<<< HEAD
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
import lombok.Getter;
import lombok.Setter;
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9

import java.util.Objects;

@Entity
@Table(name = "tb_produtos")
<<<<<<< HEAD
<<<<<<< HEAD
=======
@Getter
@Setter
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
@Getter
@Setter
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
<<<<<<< HEAD
<<<<<<< HEAD
    private String nome;
    @Column(columnDefinition = "Text")
    private String descricao;
    private double preco;
    private String imgUrl;

    public Produto() {}

    public Produto(long id, String nome, String descricao, double preco, String imgUrl) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.imgUrl = imgUrl;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
=======
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9

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
<<<<<<< HEAD
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
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
