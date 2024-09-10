package com.acme.revisao.repository;

import com.acme.revisao.model.*;
import org.springframework.data.jpa.repository.*;

import java.util.*;

public interface RevisaoRepository extends JpaRepository<Revisao, Long> {
    List<Revisao> findAllByCarroId (Long carroId);
}
