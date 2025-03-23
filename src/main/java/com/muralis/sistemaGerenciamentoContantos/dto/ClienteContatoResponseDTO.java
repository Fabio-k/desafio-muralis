package com.muralis.sistemaGerenciamentoContantos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Setter
@Getter
public class ClienteContatoResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate data_nascimento;
    private String endereco;
    private List<ContatoResponseDto> contatos;
}
