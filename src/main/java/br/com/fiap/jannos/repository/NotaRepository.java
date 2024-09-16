package br.com.fiap.jannos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.jannos.model.Nota;

@Repository
public interface NotaRepository extends JpaRepository<Nota, Long> {

}
