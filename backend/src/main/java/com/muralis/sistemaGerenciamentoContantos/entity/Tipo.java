package com.muralis.sistemaGerenciamentoContantos.entity;

public enum Tipo {
    EMAIL("E-mail"), TELEFONE("Telefone");

    private final String valor;

    Tipo(String valor) {
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
