package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
public class CarroService {
    public Carro getById (Long id) {
        RestClient restClient = RestClient.create();
        var serverUrl = String.format("http://localhost:8081/%d", id);
        return restClient.get().uri(serverUrl).retrieve().toEntity(Carro.class).getBody();
    }
}
