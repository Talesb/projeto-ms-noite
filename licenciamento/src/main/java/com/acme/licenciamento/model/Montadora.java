package com.acme.licenciamento.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Montadora {

    private long id;

    private String nome;

    private Pais pais;

}
