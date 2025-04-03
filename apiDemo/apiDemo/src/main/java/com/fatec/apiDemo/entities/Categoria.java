package com.fatec.apiDemo.entities;

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
    private int id;

    @Column(name="nome_cat",length=200,nullable=false)
    private String nome_cat;

    @OneToMany
    private List<Produto> produtos;

    public Categoria() {}

    public Categoria( String nome) {
        this.nome_cat = nome;
    }



}
