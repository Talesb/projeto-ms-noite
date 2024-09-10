package com.acme.carro.service.client;

import com.acme.carro.model.*;
import org.springframework.cloud.openfeign.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@FeignClient("REVISAO-SERVICE")
public interface RevisaoClient {
    @GetMapping("/{id}")
    List<Revisao> getById(@PathVariable  Long id);
}
