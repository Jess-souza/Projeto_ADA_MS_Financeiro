package com.example.estacionamento.payloads.request;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class PagamentoDoEstacionamentoRequest {
    @NotNull
    private ClienteRequest cliente;

    @NotNull
    private List<ValorReservaRequest> valorReserva;

}
