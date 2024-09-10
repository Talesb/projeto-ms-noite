package com.acme.revisao.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Revisao {

    @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "carro_id")
    private long carroId;
    private String descricao;
    private Double precoTotal;

}
