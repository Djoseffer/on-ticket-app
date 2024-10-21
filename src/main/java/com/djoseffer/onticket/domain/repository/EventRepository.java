package com.djoseffer.onticket.domain.repository;

import com.djoseffer.onticket.domain.Event;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
    void save(Event event);

    Optional<Event> findById(Long id);

    List<Event> findAll();
}
