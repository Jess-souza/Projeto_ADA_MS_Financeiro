package com.example.estacionamento.service;

import com.example.estacionamento.entity.ValorReserva;
import com.example.estacionamento.repository.ValorReservaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveOrCreateValorReservaService {
    private final ValorReservaRepository valorReservaRepository;

    public ValorReserva execute(ValorReserva valorReserva) {
        return valorReservaRepository.findByIdentificador(valorReserva.getIdentificador())
                .orElse(valorReservaRepository.save(valorReserva));
    }
}
