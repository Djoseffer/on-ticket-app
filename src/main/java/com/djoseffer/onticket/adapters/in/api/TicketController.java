package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.application.service.TicketService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public ResponseEntity<TicketReqestDto> createTicket() {

    }
}
