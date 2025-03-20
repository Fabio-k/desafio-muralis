package com.muralis.sistemaGerenciamentoContantos.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "endereco")
@NoArgsConstructor
@Getter
@Setter
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "end_id")
    private Long id;

    @OneToOne
    @JoinColumn(name = "end_cli_id")
    private Cliente cliente;

    @Column(name = "end_rua")
    private String rua;

    @Column(name = "end_bairro")
    private String bairro;

    @Column(name = "end_cidade")
    private String cidade;

    @Column(name = "end_estado")
    private  String estado;

    @Column(name = "end_pais")
    private String pais;
}
