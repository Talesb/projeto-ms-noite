package com.acme.venda.service;

import com.acme.venda.model.*;
import com.acme.venda.service.clients.*;
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
