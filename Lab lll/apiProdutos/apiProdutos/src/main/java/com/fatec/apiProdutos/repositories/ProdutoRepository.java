package com.fatec.apiProdutos.repositories;

import com.fatec.apiProdutos.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Busca os produtos pela disponibilidade
    List<Produto> findByDisponivel(boolean disponivel);

    // Busca os produtos pela categoria
    List<Produto> findAllByCategoriaId(long categoria_id);

    List<Produto> findByDisponivelAndCategoriaId(boolean disponivel, Long categoriaId);

}
