package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.domain.Ticket;

import java.util.List;

public interface TicketServiceImpl {

    List<Ticket> findTicketsByEvent();

    Ticket purchaseTicket(String eventId, String ticketId, String UserId);
}

