package com.acme.carro.service.impl;

import com.acme.carro.model.*;
import com.acme.carro.repository.*;
import com.acme.carro.service.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class CarroServiceImpl implements CarroService {

    private final CarroRepository carroRepository;

    @Override
    public Carro create (Carro carro) {
        return carroRepository.save(carro);
    }

    @Override
    public Optional<Carro> findById (Long id) {
        return carroRepository.findById(id);
    }

    @Override
    public List<Carro> findAll () {
        return carroRepository.findAll();
    }

    @Override
    public void deleteById (Long id) {
        carroRepository.deleteById(id);
    }

    @Override
    public Carro update (Carro carro) {
        return carroRepository.save(carro);
    }

}
