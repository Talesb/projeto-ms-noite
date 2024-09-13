package com.acme.documento.controller;

import com.acme.documento.model.*;
import com.acme.documento.service.*;
import com.fasterxml.jackson.core.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class DocumentoController {

    private final DocumentoService documentoService;

    @GetMapping("/emitir/{vendaId}")
    public ResponseEntity<?> emitir (@PathVariable String vendaId) {
        Documento documento = Documento.builder().vendaId(vendaId).id(new Random().nextLong()).build();
        documento.setTipo(TipoDocumento.ORDEM_DE_SERVICO);
        documento.setStatus(Status.PENDENTE);
        try {
            Documento nota = documentoService.emitir(documento);
            return ResponseEntity.ok().body(nota);
        } catch (JsonProcessingException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getNota (@PathVariable Long id) {
        Documento byId = documentoService.findById(id);
        return ResponseEntity.ok(byId);

    }
}
