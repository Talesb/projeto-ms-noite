package com.acme.revisao.controller;

import com.acme.revisao.model.*;
import com.acme.revisao.service.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/")
@Slf4j
@RequiredArgsConstructor
public class RevisaoController {

    private final RevisaoService revisaoService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getRevisao (@PathVariable Long id) {
        log.info("Get revisão: {}", id);
        List<Revisao> allByCarroId = revisaoService.getAllByCarroId(id);
        if (allByCarroId.isEmpty()) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok(allByCarroId);
        }
    }

}
