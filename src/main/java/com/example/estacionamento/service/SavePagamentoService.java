package com.example.estacionamento.service;

import com.example.estacionamento.entity.Pagamento;
import com.example.estacionamento.repository.PagamentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SavePagamentoService {

    private final PagamentoRepository pagamentoRepository;

    public Pagamento executar(Pagamento pagamento) {
        return pagamentoRepository.save(pagamento);
    }
}
