package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.math.*;

@Service
@RequiredArgsConstructor
public class LicenciamentoService {

    private final CarroService carroService;
    private final MontadoraService montadoraService;

    public BigDecimal calcularLicenciamentoTotal (VendaPayLoad vendaPayload) {
        return vendaPayload.itens().stream().map(this::calcularImposto).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularImposto (ItemVenda itemVenda) {
        Carro carro = carroService.getById(itemVenda.getCarroId());
        Montadora montadora = montadoraService.getById(carro.getIdMontadora());
        BigDecimal taxa = getTaxas(montadora.getPais());
        return carro.getPreco().multiply(taxa).multiply(new BigDecimal(itemVenda.getQuantidade()));

    }

    private BigDecimal getTaxas (Pais pais) {
        return switch (pais) {
            case USA -> new BigDecimal("0.45");
            case EUROPA -> new BigDecimal("0.31");
            case BRASIL -> new BigDecimal("0.05");
            case JAPAO -> new BigDecimal("0.27");
            case ALEMANHA -> new BigDecimal("0.22");
            case FRANCA -> new BigDecimal("0.29");
            case ITALIA -> new BigDecimal("0.25");
            case CANADA -> new BigDecimal("0.33");
            case AUSTRALIA -> new BigDecimal("0.37");
        };
    }

}
