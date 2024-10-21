package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.domain.Ticket;

import java.util.List;

public interface TicketServiceImpl {

    List<Ticket> findTicketsByEvent();

    Ticket purchaseTicket(Long eventId, Long ticketId, Long UserId);
}

