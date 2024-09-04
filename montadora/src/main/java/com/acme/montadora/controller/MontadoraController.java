package com.acme.montadora.controller;

import com.acme.montadora.model.*;
import com.acme.montadora.service.*;
import lombok.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class MontadoraController {

    private final MontadoraService montadoraService;

    @GetMapping
    public ResponseEntity<List<Montadora>> getAll () {
        return ResponseEntity.ok(montadoraService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById (@PathVariable Long id) {
        Optional<Montadora> optional = montadoraService.getById(id);
        if (optional.isPresent()) {
            return ResponseEntity.ok(optional.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
