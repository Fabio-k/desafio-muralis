package com.muralis.sistemaGerenciamentoContantos.repository;

import com.muralis.sistemaGerenciamentoContantos.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    @Query("SELECT c FROM Cliente c WHERE (:nome IS NULL OR c.nome LIKE :nome) AND (:cpf IS NULL OR c.cpf LIKE :cpf)")
    List<Cliente> findWithFilter(String nome, String cpf);
}
