package com.example.estacionamento.service;

import com.example.estacionamento.entity.Pagamento;
import com.example.estacionamento.payloads.response.RelatorioCliente;
import com.example.estacionamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SomaVagasPorClienteService {
    private final PagamentoRepository pagamentoRepository;
    @Cacheable(cacheNames = "rlcliente", key ="#identificadorCliente" )
    public RelatorioCliente execute(String identificadorCliente){

        log.info("Relatorio de cliente solicitado");
        List<Pagamento> pagamentos = pagamentoRepository.findByClienteIdentificador(identificadorCliente);
        RelatorioCliente relatorioCliente = new RelatorioCliente();
        relatorioCliente.setIdentificador(identificadorCliente);
        relatorioCliente.setValor(pagamentos.stream().flatMap(pagamento -> pagamento.getValorReservas().stream()).count());
        return relatorioCliente;
    }
}
