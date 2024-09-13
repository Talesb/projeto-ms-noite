package com.acme.documento.service;

import com.acme.documento.model.*;
import com.acme.documento.rabbitmq.*;
import com.acme.documento.repository.*;
import com.fasterxml.jackson.core.*;
import lombok.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
@RequiredArgsConstructor
public class DocumentoService {

    private final DocumentoProducer documentoProducer;
    private final DocumentoRepository documentoRepository;

    public Documento emitir (Documento documento) throws JsonProcessingException {
        documentoProducer.send(documento);
        return documentoRepository.save(documento);
    }

    public List<Documento> findAll () {
        return documentoRepository.findAll();
    }

    public Documento findById (Long id) {
        return documentoRepository.findById(id).get();
    }

}
