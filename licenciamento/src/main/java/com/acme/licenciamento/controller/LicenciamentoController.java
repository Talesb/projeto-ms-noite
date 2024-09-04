package com.acme.licenciamento.controller;

import com.acme.licenciamento.model.*;
import com.acme.licenciamento.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.math.*;
import java.util.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class LicenciamentoController {

    private final LicenciamentoService licenciamentoService;

    @PostMapping
    public ResponseEntity calcularLicenciamento (@RequestBody VendaPayLoad vendaPayload) {
        BigDecimal licenciamentoTotal = licenciamentoService.calcularLicenciamentoTotal(vendaPayload);
        return ResponseEntity.ok(Map.of("totalLicenciamento", licenciamentoTotal));
    }

}
