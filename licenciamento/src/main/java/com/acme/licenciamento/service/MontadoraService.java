package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class MontadoraService {
    public Montadora getById (Long id) {
        var serverUrl = String.format("http://localhost:8082/%d", id);
        RestClient restClient = RestClient.create();
        return restClient.get().uri(serverUrl).retrieve().toEntity(Montadora.class).getBody();
    }
}
