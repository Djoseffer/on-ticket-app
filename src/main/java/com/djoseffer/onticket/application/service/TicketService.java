package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.application.serviceImpl.TicketServiceImpl;
import com.djoseffer.onticket.domain.Ticket;

import java.util.List;

public class TicketService implements TicketServiceImpl {
    @Override
    public List<Ticket> findTicketsByEvent() {
        return List.of();
    }

    @Override
    public Ticket purchaseTicket(Long eventId, Long ticketId, Long UserId) {
        return null;
    }
}
