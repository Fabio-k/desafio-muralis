package com.muralis.sistemaGerenciamentoContantos.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContatoResponseDto {
    private Long id;
    private Long cliente_id;
    private String tipo;
    private String valor;
    private String observacao;
}
