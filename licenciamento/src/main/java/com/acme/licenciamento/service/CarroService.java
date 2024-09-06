package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroClient carroClient;

    public Carro getById (Long id) {
        return carroClient.getById(id);
    }
}
