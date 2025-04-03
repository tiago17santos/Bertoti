package com.fatec.apiDemo.repositories;

import com.fatec.apiDemo.entities.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

<<<<<<< HEAD
<<<<<<< HEAD
public interface ProdutoRepository extends JpaRepository<Produto, Long> {
=======
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
import java.util.List;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    // Busca os produtos pela disponibilidade
    List<Produto> findByDisponivel(boolean disponivel);

    // Busca os produtos pela categoria
    List<Produto> findByCategoriaId(Long categoriaId);
<<<<<<< HEAD
>>>>>>> 53894943fd23b326ef418f3893312d3ccf5fc5fb
=======
>>>>>>> 6ac3cb57d1913cc621a241383e81dcf56f4252a9
}
