package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.application.serviceImpl.TicketServiceImpl;
import com.djoseffer.onticket.domain.Ticket;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements TicketServiceImpl {
    @Override
    public List<Ticket> findTicketsByEvent() {
        return List.of();
    }

    @Override
    public Ticket purchaseTicket(String eventId, String ticketId, String UserId) {
        return null;
    }
}
