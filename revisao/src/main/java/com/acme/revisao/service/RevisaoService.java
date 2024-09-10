package com.acme.revisao.service;

import com.acme.revisao.model.*;
import com.acme.revisao.repository.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class RevisaoService {
    private final RevisaoRepository revisaoRepository;

    public List<Revisao> getAllByCarroId (Long carroId) {
        return revisaoRepository.findAllByCarroId(carroId);
    }
    
}
