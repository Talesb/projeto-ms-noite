package com.acme.licenciamento.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemVenda {
    private long quantidade;
    private long carroId;
}
