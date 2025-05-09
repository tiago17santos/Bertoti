package com.fatec.apiProdutos.services;

import com.fatec.apiProdutos.Dto.CategoriaDto;
import com.fatec.apiProdutos.entities.Categoria;
import com.fatec.apiProdutos.repositories.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @Transactional
    public CategoriaDto salvar(CategoriaDto categoria) {
        Categoria cat = new Categoria();
        cat.setNomeCat(categoria.nomeCat());
        cat = categoriaRepository.save(cat);
        return converteEmDto(cat);
    }

    @Transactional
    public List<CategoriaDto> listarTodas() {
        List<Categoria> cad = categoriaRepository.findAll();

        return cad.stream().map(this::converteEmDto).collect(Collectors.toList());
    }

    private CategoriaDto converteEmDto(Categoria categoria){
        return new CategoriaDto(
                categoria.getId(),
                categoria.getNomeCat()
        );
    }
}
