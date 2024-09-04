package com.acme.venda.model;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ItemVenda {
    private long quantidade;
    private long carroId;
}
