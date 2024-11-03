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
        kafkaTemplate.send(eventId, quantitySold.toString());
    }
}
