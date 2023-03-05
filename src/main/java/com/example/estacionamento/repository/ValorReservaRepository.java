package com.example.estacionamento.repository;

import com.example.estacionamento.entity.ValorReserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ValorReservaRepository extends JpaRepository<ValorReserva, Long> {
    Optional<ValorReserva> findByIdentificador(String identificador);
}
