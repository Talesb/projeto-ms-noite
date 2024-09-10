package com.acme.carro.controller;

import com.acme.carro.model.*;
import com.acme.carro.payload.*;
import com.acme.carro.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
@Slf4j
public class CarroController {

    private final CarroService carroService;
    private final RevisaoService revisaoService;

    @GetMapping
    public ResponseEntity<?> findAll () {
        return ResponseEntity.ok(carroService.findAll());
    }

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

    @GetMapping("/{id}/completo")
    public ResponseEntity<?> findByIdComRevisoes (@PathVariable Long id) {
        log.info("Find Carro by ID - Completo {}", id);

        Optional<Carro> optCarro = carroService.findById(id);

        if (optCarro.isPresent()) {
            List<Revisao> allById = revisaoService.getAllById(id);
            ResponsePayload responsePayload = new ResponsePayload(optCarro.get(),allById);
            return ResponseEntity.ok(responsePayload);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete (@PathVariable Long id) {
        carroService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<?> save (@RequestBody Carro carro) {
        Carro saved = carroService.create(carro);
        return ResponseEntity.ok(saved);
    }

    @PutMapping
    public ResponseEntity<?> update (@RequestBody Carro carro) {
        carroService.update(carro);
        return ResponseEntity.ok().build();
    }
}