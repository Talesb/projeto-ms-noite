package com.acme.carro.service;

import com.acme.carro.model.*;
import com.acme.carro.service.client.*;
import io.github.resilience4j.circuitbreaker.annotation.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.concurrent.*;

@Service
@RequiredArgsConstructor
@Slf4j
public class RevisaoService {
    private final RevisaoClient revisaoClient;
    private static Map<Long, List<Revisao>> CACHE = new ConcurrentHashMap<>();

    @CircuitBreaker(name = "revisaoService", fallbackMethod = "buscarNoCache")
    public List<Revisao> getAllById(Long carroId){
        List<Revisao> revisoes = revisaoClient.getById(carroId);
        CACHE.put(carroId, revisoes);
        return revisaoClient.getById(carroId);
    }

    private List<Revisao> buscarNoCache(Long carroId, Throwable e){
        log.info("Buscando no Cache");
        return CACHE.getOrDefault(carroId,new ArrayList<>());
    }
}
