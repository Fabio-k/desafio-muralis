package com.muralis.sistemaGerenciamentoContantos.dto;

import com.muralis.sistemaGerenciamentoContantos.entity.Tipo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDto {
    @NotNull(message = "Tipo é um campo obrigatório")
    private Tipo tipo;

    @NotBlank(message = "Valor não pode ficar em branco")
    private String valor;

    private String observacao;
}
