package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import com.acme.licenciamento.service.clients.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class CarroService {

    private final CarroClient carroClient;

    public Carro getById (Long id) {
        return carroClient.getById(id);
    }
}
