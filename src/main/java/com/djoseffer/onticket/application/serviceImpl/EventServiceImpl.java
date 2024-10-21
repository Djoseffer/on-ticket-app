package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.domain.Event;
import com.djoseffer.onticket.domain.Ticket;

import java.util.List;

public interface EventServiceImpl {

    void createEvent(Long userId, Ticket ticket);

    List<Event> findAllEvents();

    Event findEventById(Long eventId);
}
