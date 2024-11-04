package com.djoseffer.onticket.domain.repository;

import com.djoseffer.onticket.domain.Ticket;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketRepository {
    void save(Ticket ticket);

    Optional<Ticket> findById(String id);

    List<Ticket> findByEventId(String eventId);
}
