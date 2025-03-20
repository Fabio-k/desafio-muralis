package com.muralis.sistemaGerenciamentoContantos.entity;

public enum Tipo {
    EMAIL("e-mail"), TELEFONE("telefone");

    private final String valor;

    Tipo(String valor){
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }
}
