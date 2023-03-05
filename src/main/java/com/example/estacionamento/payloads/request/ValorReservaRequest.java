package com.example.estacionamento.payloads.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ValorReservaRequest {

    @NotNull
    private ClienteRequest cliente;

    @Min(value = 1, message = "O valor a ser cobrado não é valido")
    private double preco;

    @NotEmpty(message = "O identificador da reserva é necessário")
    private String identificador;

}
