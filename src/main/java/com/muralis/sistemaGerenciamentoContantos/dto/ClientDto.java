package com.muralis.sistemaGerenciamentoContantos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class ClientDto {
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private String endereco;
}
