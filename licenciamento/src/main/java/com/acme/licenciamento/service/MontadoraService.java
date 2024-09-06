package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import com.acme.licenciamento.service.clients.*;
import lombok.*;
import org.springframework.stereotype.*;
import org.springframework.web.client.*;

@Service
@RequiredArgsConstructor
public class MontadoraService {

    private final MontadoraClient montadoraClient;

    public Montadora getById (Long id) {
        return montadoraClient.getById(id);
    }
    
}
