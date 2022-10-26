package br.senac.tads.dsw.exemplosspring.produto;

import java.util.List;
import java.util.Optional;

public interface ProdutoRepository {

    List<Produto> findAll(int pagina, int quantidade);

    List<Produto> findByCategoria(List<Integer> idsCat, int pagina, int quantidade);

    Optional<Produto> findById(Long id);

    Produto save(Produto p);

    void deleteById(Long id);

}
