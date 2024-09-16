package br.com.fiap.jannos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.jannos.model.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
