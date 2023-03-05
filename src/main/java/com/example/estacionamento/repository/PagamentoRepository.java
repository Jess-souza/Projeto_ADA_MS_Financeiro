package com.example.estacionamento.repository;

import com.example.estacionamento.entity.Pagamento;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
    @EntityGraph(value = "Pagamento.valorReserva")
    List<Pagamento> findByClienteIdentificador(String identificadorCliente);
}
