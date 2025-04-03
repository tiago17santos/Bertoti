package com.fatec.apiDemo.repositories;

import com.fatec.apiDemo.entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    // Aqui você pode adicionar métodos personalizados de consulta se necessário
}

