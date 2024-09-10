package com.acme.carro.model;

import jakarta.persistence.*;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Revisao {

    private long id;
    private long carroId;
    private String descricao;
    private Double precoTotal;

}
