package com.acme.venda.service.clients;

import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("DOCUMENTO-SERVICE")
public interface DocumentoClient {

    @GetMapping("/emitir/{vendaId}")
    void emitir (@PathVariable("vendaId") String vendaId);

}
