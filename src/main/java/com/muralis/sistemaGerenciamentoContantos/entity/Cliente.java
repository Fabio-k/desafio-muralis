package com.muralis.sistemaGerenciamentoContantos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "cliente")
@NoArgsConstructor
@Getter
@Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cli_id")
    private Long id;

    @Column(name = "cli_nome")
    private String nome;

    @Column(name = "cli_cpf")
    private String cpf;

    @Column(name = "cli_data_nascimento")
    private LocalDate data_nascimento;

    @Column(name = "cli_endereco")
    private String endereco;
}
