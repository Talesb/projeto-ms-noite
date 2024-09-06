package com.acme.venda.service.clients;

import com.acme.venda.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

@FeignClient("CARRO-SERVICE")
public interface CarroClient {

    @GetMapping("/{id}")
    Carro getById (@PathVariable("id") Long id);

}
