package com.acme.venda.service;

import com.acme.venda.model.*;
import com.acme.venda.service.clients.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class LicenciamentoService {

    private final LicenciamentoClient licenciamentoClient;

    public LicenciamentoResponsePayload obterTotalLicenciamento (Venda venda) {
        return licenciamentoClient.calcularTotalLicenciamento(venda);
    }
}
