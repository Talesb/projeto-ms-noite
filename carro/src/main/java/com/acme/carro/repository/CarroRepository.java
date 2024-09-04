package com.acme.carro.repository;

import com.acme.carro.model.*;
import org.springframework.data.jpa.repository.*;

public interface CarroRepository extends JpaRepository<Carro, Long> {
}
