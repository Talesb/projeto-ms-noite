package com.acme.venda.model;

import lombok.*;

import java.math.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Carro {

    private long id;

    private String nome;

    private BigDecimal preco;

    private String montadora;

    private long idMontadora;

}
