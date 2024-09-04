package com.acme.venda.service;

import com.acme.venda.model.*;
import com.acme.venda.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    public Venda salvar(Venda venda) {
        return vendaRepository.save(venda);
    }

}
