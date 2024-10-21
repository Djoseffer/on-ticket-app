package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.application.serviceImpl.EventServiceImpl;
import com.djoseffer.onticket.domain.Event;
import com.djoseffer.onticket.domain.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService implements EventServiceImpl {
    @Override
    public void createEvent(Long userId, Ticket ticket) {

    }

    @Override
    public List<Event> findAllEvents() {
        return List.of();
    }

    @Override
    public Event findEventById(Long eventId) {
        return null;
    }
}
