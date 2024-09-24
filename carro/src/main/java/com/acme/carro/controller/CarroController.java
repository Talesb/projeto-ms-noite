package com.acme.carro.controller;

import com.acme.carro.model.*;
import com.acme.carro.payload.*;
import com.acme.carro.service.*;
import io.swagger.v3.oas.annotations.*;
import io.swagger.v3.oas.annotations.tags.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Tag(name = "Carro Controller", description = "Operações permitidas com Carros")
@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CarroController {

    private final CarroService carroService;
    private final RevisaoService revisaoService;

    @Operation(summary = "Obter todos os carros disponíveis", description = "Obtém os carros disponíveis no sistema")
    @GetMapping
    public ResponseEntity<?> findAll () {
        return ResponseEntity.ok(carroService.findAll());
    }

    @Operation(summary = "Obter carro pelo ID", description = "Obtém o carro do sistema")
    @GetMapping("/{id}")
    public ResponseEntity<?> findById (@PathVariable Long id) {
        log.info("Find Carro by ID {}", id);
        Optional<Carro> optCarro = carroService.findById(id);
        if (optCarro.isPresent()) {
            return ResponseEntity.ok(optCarro.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Obter carro pelo ID", description = "\"Obtém o carro do sistema buscando pelo ID tais quais suas revisões, caso existam")
    @GetMapping("/{id}/completo")
    public ResponseEntity<?> findByIdComRevisoes (@PathVariable Long id) {
        log.info("Find Carro by ID - Completo {}", id);

        Optional<Carro> optCarro = carroService.findById(id);

        if (optCarro.isPresent()) {
            List<Revisao> allById = revisaoService.getAllById(id);
            ResponsePayload responsePayload = new ResponsePayload(optCarro.get(), allById);
            return ResponseEntity.ok(responsePayload);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Deletar o carro pelo ID", description = "Deleta o carro pelo ID")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Criar um novo carro no sistema", description = "Cria um novo carro no sistema")
    @PostMapping
    public ResponseEntity<?> save (@RequestBody Carro carro) {
        Carro saved = carroService.create(carro);
        return ResponseEntity.ok(saved);
    }

    @Operation(summary = "Atualizar carro já presente no sistema", description = "Atualiza um carro já presente no sistema")
    @PutMapping
    public ResponseEntity<?> update (@RequestBody Carro carro) {
        carroService.update(carro);
        return ResponseEntity.ok().build();
    }
}