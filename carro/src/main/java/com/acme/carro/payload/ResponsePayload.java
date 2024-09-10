package com.acme.carro.payload;

import com.acme.carro.model.*;

import java.util.*;

public record ResponsePayload(Carro carro, List<Revisao> revisoes) {
}