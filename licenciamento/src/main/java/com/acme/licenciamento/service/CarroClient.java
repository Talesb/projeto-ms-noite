package com.acme.licenciamento.service;

import com.acme.licenciamento.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("CARRO-SERVICE")
public interface CarroClient {

    @GetMapping("/{id}")
    Carro getById (@PathVariable("id") Long id);

}
