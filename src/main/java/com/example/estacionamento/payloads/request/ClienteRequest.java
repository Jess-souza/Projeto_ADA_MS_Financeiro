package com.example.estacionamento.payloads.request;

import lombok.Data;

@Data
public class ClienteRequest {
    private String cpf;
    private String identificador;
    private String nomeCliente;
}
