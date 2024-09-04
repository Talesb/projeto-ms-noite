package com.acme.venda.repository;

import com.acme.venda.model.*;
import org.springframework.data.mongodb.repository.*;

public interface VendaRepository extends MongoRepository<Venda, String> {
}
