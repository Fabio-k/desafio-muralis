package com.muralis.sistemaGerenciamentoContantos.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Setter
@Getter
public class ClienteContatoResponseDTO {
    private Long id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private LocalDate formattedBirthDate;
    private String endereco;
    private List<ContatoResponseDto> contatos;

    public String getFormattedBirthDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formattedBirthDate.format(formatter);
    }
}
