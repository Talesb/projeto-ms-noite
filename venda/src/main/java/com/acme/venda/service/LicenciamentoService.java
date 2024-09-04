package com.acme.venda.service;

import com.acme.venda.model.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

import java.math.*;

@Service
public class LicenciamentoService {
    public LicenciamentoResponsePayload getTotalLicenciamento (Venda venda) {
        var serverUrl = "http://localhost:8084";
        RestClient restClient = RestClient.create();
        return restClient.post().uri(serverUrl).body(venda).retrieve().toEntity(LicenciamentoResponsePayload.class)
                .getBody();
    }
}
