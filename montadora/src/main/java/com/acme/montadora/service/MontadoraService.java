package com.acme.montadora.service;

import com.acme.montadora.model.*;
import com.acme.montadora.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;
@Service
@RequiredArgsConstructor
public class MontadoraService {

    private final MontadoraRepository montadoraRepository;

    public List<Montadora> getAll () {
        return montadoraRepository.findAll();
    }

    public Optional<Montadora> getById (long id) {
        return montadoraRepository.findById(id);
    }

}
