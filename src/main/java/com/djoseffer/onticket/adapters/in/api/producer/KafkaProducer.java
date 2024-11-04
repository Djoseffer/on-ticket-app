package com.djoseffer.onticket.adapters.in.api.producer;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendTicketsSold(String eventId, Long quantitySold) {
        String message = String.format("{\"eventId\":\"%s\",\"quantitySold\":%d}", eventId, quantitySold);
        kafkaTemplate.send("tickets-sold", message);
    }
}
