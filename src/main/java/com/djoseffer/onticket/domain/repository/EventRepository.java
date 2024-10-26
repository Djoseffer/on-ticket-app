package com.djoseffer.onticket.domain.repository;

import com.djoseffer.onticket.domain.Event;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EventRepository {
    void save(Event event);

    Optional<Event> findById(String id);

    List<Event> findAll();
    List<Event> findEventByUserId(String userId);
}
