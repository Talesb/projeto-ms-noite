package com.acme.venda.controller;

import com.acme.venda.model.*;
import com.acme.venda.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService vendaService;
    private final LicenciamentoService licenciamentoService;

    @PostMapping
    public ResponseEntity create (@RequestBody Venda venda) {
        LicenciamentoResponsePayload lincenciamentoResponse = licenciamentoService.obterTotalLicenciamento(venda);
        venda.setTotalLicenciamento(lincenciamentoResponse.totalLicenciamento());
        venda.setTotalVenda(vendaService.calcularTotalVenda(venda));
        Venda vendaSalva = vendaService.salvar(venda);
        return ResponseEntity.status(HttpStatus.CREATED).body(vendaSalva);
    }

}
