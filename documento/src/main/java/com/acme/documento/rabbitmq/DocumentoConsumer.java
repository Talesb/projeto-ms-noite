package com.acme.documento.rabbitmq;

import com.acme.documento.model.*;
import com.fasterxml.jackson.databind.*;
import lombok.*;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.*;

@Component
@RequiredArgsConstructor
public class DocumentoConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @RabbitListener(queues = {"documento-ok.queue"})
    public void receive (@Payload Documento documento) {
        System.out.println("Documento recebido: " + documento);
    }
}
