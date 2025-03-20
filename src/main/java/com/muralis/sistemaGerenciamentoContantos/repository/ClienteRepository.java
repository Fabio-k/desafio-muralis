package com.muralis.sistemaGerenciamentoContantos.repository;

import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
