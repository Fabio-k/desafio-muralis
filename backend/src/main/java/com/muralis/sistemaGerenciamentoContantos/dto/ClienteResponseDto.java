package com.muralis.sistemaGerenciamentoContantos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class ClienteResponseDto {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private String endereco;
}
