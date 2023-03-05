package com.example.estacionamento.service;

import com.example.estacionamento.entity.Cliente;
import com.example.estacionamento.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RetrieveOrSaveClienteService {

    private final ClienteRepository clienteRepository;

    public Cliente execute(Cliente cliente) {
        return clienteRepository.findByIdentificador(cliente.getIdentificador())
                .orElse(clienteRepository.save(cliente));
    }
}
