package com.muralis.sistemaGerenciamentoContantos.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

@Setter
@Getter
public class ClientDto {

    @NotBlank(message = "Nome não pode estar em branco")
    private String nome;

    @NotBlank(message = "CPF não pode estar em branco")
    @Length(min = 11, max = 11, message = "CPF deve conter 11 digitos")
    private String cpf;

    @NotNull(message = "Data de nascimento é obrigatória")
    @Past(message = "Data de nascimento deve ser válida")
    private LocalDate dataNascimento;


    private String endereco;
}
