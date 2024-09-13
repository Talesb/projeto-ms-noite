package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.*;

import java.math.*;

@Service
@RequiredArgsConstructor
public class LicenciamentoService {

    @Value("${taxas.usa}")
    private BigDecimal taxaUSA;

    @Value("${taxas.europa}")
    private BigDecimal taxaEuropa;

    @Value("${taxas.brasil}")
    private BigDecimal taxaBrasil;

    @Value("${taxas.japao}")
    private BigDecimal taxaJapao;

    @Value("${taxas.alemanha}")
    private BigDecimal taxaAlemanha;

    @Value("${taxas.franca}")
    private BigDecimal taxaFranca;

    @Value("${taxas.italia}")
    private BigDecimal taxaItalia;

    @Value("${taxas.canada}")
    private BigDecimal taxaCanada;

    @Value("${taxas.australia}")
    private BigDecimal taxaAustralia;

    private final CarroService carroService;
    private final MontadoraService montadoraService;

    public BigDecimal calcularLicenciamentoTotal (VendaPayLoad vendaPayload) {
        return vendaPayload.itens().stream().map(this::calcularLicenciamento).reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    private BigDecimal calcularLicenciamento (ItemVenda itemVenda) {
        Carro carro = carroService.getById(itemVenda.getCarroId());
        Montadora montadora = montadoraService.getById(carro.getIdMontadora());
        BigDecimal taxa = getTaxas(montadora.getPais());

        BigDecimal precoOriginal = carro.getPreco();

        BigDecimal desconto = BigDecimal.ZERO;
        if (itemVenda.getQuantidade() > 5) {
            desconto = precoOriginal.multiply(new BigDecimal("0.10"));
        }

        BigDecimal precoComDesconto = precoOriginal.subtract(desconto);

        return precoComDesconto.multiply(taxa).multiply(new BigDecimal(itemVenda.getQuantidade()));

    }

    private BigDecimal getTaxas (Pais pais) {
        return switch (pais) {
            case USA -> taxaUSA;
            case EUROPA -> taxaEuropa;
            case BRASIL -> taxaBrasil;
            case JAPAO -> taxaJapao;
            case ALEMANHA -> taxaAlemanha;
            case FRANCA -> taxaFranca;
            case ITALIA -> taxaItalia;
            case CANADA -> taxaCanada;
            case AUSTRALIA -> taxaAustralia;
        };
    }

}
