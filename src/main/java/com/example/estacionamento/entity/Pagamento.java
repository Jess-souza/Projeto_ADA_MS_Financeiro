package com.example.estacionamento.entity;

import lombok.Data;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "Pagamento")
@NamedEntityGraph(name = "Pagamento.valorReserva", attributeNodes = @NamedAttributeNode("valorReservas"))
public class Pagamento {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @CreatedDate
    private LocalDateTime dataCriacao;

    @OneToMany(mappedBy = "pagamento", cascade = {CascadeType.PERSIST})
    private List<ValorReserva> valorReservas;

    public void adicionarReservas(List<ValorReserva> valorReservas) {
        valorReservas.forEach(valorReserva->valorReserva.setPagamento(this));
        if(Objects.isNull(this.valorReservas)){
            this.valorReservas = new ArrayList<>();
        }
        this.valorReservas.addAll(valorReservas);
    }
}
