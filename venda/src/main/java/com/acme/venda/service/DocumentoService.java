package com.acme.venda.service;

import com.acme.venda.service.clients.*;
import lombok.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class DocumentoService {
    private final DocumentoClient documentoClient;

    public void emitir (String vendaId) {
        documentoClient.emitir(vendaId);
    }
}
