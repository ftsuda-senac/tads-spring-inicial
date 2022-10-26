package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {

    List<Categoria> findAll();

    Optional<Categoria> findById(Integer id);

    Categoria save(Categoria cat);

}
