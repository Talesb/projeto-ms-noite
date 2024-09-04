package com.acme.carro.service;

import com.acme.carro.model.*;

import java.util.*;

public interface CarroService {

    Carro create (Carro carro);

    Optional<Carro> findById (Long id);

    List<Carro> findAll ();

    void deleteById (Long id);

    Carro update (Carro carro);
}
