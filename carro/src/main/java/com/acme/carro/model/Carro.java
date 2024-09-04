package com.acme.carro.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.*;

@Data
@AllArgsConstructor@NoArgsConstructor@Builder
@Entity
public class Carro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String nome;

    private BigDecimal preco;

    private String montadora;

    @Column(name = "montadora_id")
    private long idMontadora;

}
