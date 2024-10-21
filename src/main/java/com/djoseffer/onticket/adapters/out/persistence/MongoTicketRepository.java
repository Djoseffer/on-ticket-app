package com.djoseffer.onticket.adapters.out.persistence;

import com.djoseffer.onticket.domain.Ticket;
import com.djoseffer.onticket.domain.repository.TicketRepository;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.List;
import java.util.Optional;

public class MongoTicketRepository implements TicketRepository {
    private final MongoTemplate mongoTemplate;

    public MongoTicketRepository(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }


    @Override
    public void save(Ticket ticket) {
        mongoTemplate.save(ticket);
    }

    @Override
    public Optional<Ticket> findById(Long id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Ticket.class));
    }

    @Override
    public List<Ticket> findByEventId(Long eventId) {
        return List.of();
    }
}
