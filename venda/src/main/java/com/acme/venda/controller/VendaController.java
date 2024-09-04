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
        LicenciamentoResponsePayload lincenciamentoResponse = licenciamentoService.getTotalLicenciamento(venda);
        System.out.println("totalLicenciamento: " + lincenciamentoResponse);
        venda.setTotalLicenciamento(lincenciamentoResponse.totalLicenciamento());
        vendaService.salvar(venda);
        return null;
    }

}
