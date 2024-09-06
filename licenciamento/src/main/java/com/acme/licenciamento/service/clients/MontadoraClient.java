package com.acme.licenciamento.service.clients;

import com.acme.licenciamento.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("MONTADORA-SERVICE")
public interface MontadoraClient {

    @GetMapping("/{id}")
    Montadora getById (@PathVariable("id") Long id);

}
