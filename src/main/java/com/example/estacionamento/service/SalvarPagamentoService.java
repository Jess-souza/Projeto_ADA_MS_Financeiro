package com.example.estacionamento.service;

import com.example.estacionamento.entity.Cliente;
import com.example.estacionamento.entity.Pagamento;
import com.example.estacionamento.entity.ValorReserva;
import com.example.estacionamento.payloads.request.PagamentoDoEstacionamentoRequest;
import com.example.estacionamento.payloads.request.ValorReservaRequest;
import com.example.estacionamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SalvarPagamentoService {

    private final RetrieveOrSaveClienteService retrieveOrSaveClienteService;

    private final PagamentoRepository pagamentoRepository;

    @CacheEvict(cacheNames = "rlfornecedor", allEntries = true)
    public void execute(PagamentoDoEstacionamentoRequest pagamentoDoEstacionamentoRequest){
        Cliente cliente = new Cliente();
        BeanUtils.copyProperties(pagamentoDoEstacionamentoRequest.getCliente(),cliente);
        List<ValorReserva> valorReservas = pagamentoDoEstacionamentoRequest.getValorReserva().stream().map(this::getValorReservas)
                .collect(Collectors.toList());

        Cliente clienteSaved = retrieveOrSaveClienteService.execute(cliente);

        Pagamento pagamento = new Pagamento();
        pagamento.setCliente(clienteSaved);
        pagamento.adicionarReservas(valorReservas);
        pagamentoRepository.save(pagamento);
    }

    private ValorReserva getValorReservas (ValorReservaRequest valorReservaRequest) {
        ValorReserva valorReserva = new ValorReserva();
        BeanUtils.copyProperties(valorReservaRequest, valorReserva);
        return valorReserva;
    }
}
