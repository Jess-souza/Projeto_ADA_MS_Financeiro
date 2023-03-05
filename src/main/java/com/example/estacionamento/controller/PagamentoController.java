package com.example.estacionamento.controller;

import com.example.estacionamento.payloads.request.PagamentoDoEstacionamentoRequest;
import com.example.estacionamento.payloads.response.RelatorioCliente;
import com.example.estacionamento.service.SalvarPagamentoService;
import com.example.estacionamento.service.SomaVagasPorClienteService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pagamento")
@RequiredArgsConstructor
@Slf4j
public class PagamentoController {
    private final SalvarPagamentoService salvarPagamentoService;
    private final SomaVagasPorClienteService somaVagasPorClienteService;
    @PostMapping(path = "/cliente")
    @ResponseStatus(HttpStatus.CREATED)
    public void receberPagamentoCliente(@RequestBody PagamentoDoEstacionamentoRequest pagamentoDoEstacionamentoRequest){
        log.info("Requisição de pagamento recebido {}",pagamentoDoEstacionamentoRequest);
        salvarPagamentoService.execute(pagamentoDoEstacionamentoRequest);
    }

    @GetMapping(path = "/relatorio/{idCliente}")
    public RelatorioCliente getRelatorioCliente(@PathVariable String idCliente){
        return somaVagasPorClienteService.execute(idCliente);
    }
}

