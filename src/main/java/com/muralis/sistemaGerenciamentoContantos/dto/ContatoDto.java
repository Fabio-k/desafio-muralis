package com.muralis.sistemaGerenciamentoContantos.dto;

import com.muralis.sistemaGerenciamentoContantos.entity.Tipo;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoDto {
    private Tipo tipo;
    private String valor;
    private String observacao;
}
