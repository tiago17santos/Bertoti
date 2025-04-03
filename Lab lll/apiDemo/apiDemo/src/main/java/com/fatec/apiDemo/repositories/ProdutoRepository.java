package com.fatec.apiDemo.repositories;

import com.fatec.apiDemo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
}
