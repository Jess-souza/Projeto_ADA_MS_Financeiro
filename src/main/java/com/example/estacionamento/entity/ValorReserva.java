package com.example.estacionamento.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ValorReserva")
public class ValorReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String identificador;

    private double preco;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_pagamento")
    private Pagamento pagamento;
}