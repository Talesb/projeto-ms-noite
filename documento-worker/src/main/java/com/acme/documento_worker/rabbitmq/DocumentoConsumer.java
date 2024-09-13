package com.acme.documento_worker.rabbitmq;

import com.acme.documento_worker.model.*;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.databind.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.*;

@Slf4j
@Component
@RequiredArgsConstructor
public class DocumentoConsumer {
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final DocumentoProducer producer;

    @RabbitListener(queues = {"documento-queue"})
    public void receive (@Payload String message) {
        try {
            Documento documento = objectMapper.readValue(message, Documento.class);
            log.info("Processando Documento: {}", documento);
            Thread.sleep(3_000);
            producer.send(documento);
        } catch (JsonProcessingException e) {
            log.error("Erro ao decodificar o documento: {}", e.getMessage());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        log.info("DocumentoConsumer received : {}", message);
    }
}
