package com.muralis.sistemaGerenciamentoContantos.repository;

import com.muralis.sistemaGerenciamentoContantos.entity.Contato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContatoRepository extends JpaRepository<Contato,Long> {
}
