package br.com.fiap.jannos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.fiap.jannos.model.Anuncio;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio, Long> {

}
