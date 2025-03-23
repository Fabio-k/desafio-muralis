package com.muralis.sistemaGerenciamentoContantos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contato")
@NoArgsConstructor
@Getter
@Setter
public class Contato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "con_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "con_cli_id")
    private Cliente cliente;

    @Enumerated(EnumType.STRING)
    @Column(name = "con_tipo")
    private Tipo tipo;

    @Column(name = "con_valor")
    private String valor;

    @Column(name = "con_observacao")
    private String observacao;
}
