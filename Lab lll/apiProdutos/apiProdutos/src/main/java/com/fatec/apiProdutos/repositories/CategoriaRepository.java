package com.fatec.apiProdutos.repositories;

import com.fatec.apiProdutos.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Aqui você pode adicionar métodos personalizados de consulta se necessário
}

