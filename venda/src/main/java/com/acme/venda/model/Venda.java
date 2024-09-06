package com.acme.venda.model;

import lombok.*;

import java.math.*;
import java.util.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Document(collection = "vendas")
public class Venda {

    @Id
    private String id;

    private List<ItemVenda> itens;

    private BigDecimal totalLicenciamento;

    private BigDecimal totalVenda;

}
