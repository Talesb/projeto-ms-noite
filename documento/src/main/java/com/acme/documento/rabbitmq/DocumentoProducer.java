package com.acme.documento.rabbitmq;

import com.acme.documento.model.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import lombok.*;
import org.springframework.amqp.core.*;
import org.springframework.stereotype.*;

@Service
@RequiredArgsConstructor
public class DocumentoProducer {
    private final AmqpTemplate amqpTemplate;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public void send (Documento documento) throws JsonProcessingException {
        amqpTemplate.convertAndSend("documento-exc", "documento-rk", objectMapper.writeValueAsString(documento));
    }
}
