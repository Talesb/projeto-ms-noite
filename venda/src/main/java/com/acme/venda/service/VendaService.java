package com.acme.venda.service;

import com.acme.venda.model.*;
import com.acme.venda.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.math.*;

@Service
@RequiredArgsConstructor
public class VendaService {

    private final VendaRepository vendaRepository;
    private final CarroService carroService;

    public Venda salvar (Venda venda) {
        return vendaRepository.save(venda);
    }

    public BigDecimal calcularTotalVenda (Venda venda) {
        return venda.getItens().stream().map(this::calcularVenda).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularVenda (ItemVenda itemVenda) {
        Carro carro = carroService.getById(itemVenda.getCarroId());
        return carro.getPreco().multiply(new BigDecimal(itemVenda.getQuantidade()));
    }

}
