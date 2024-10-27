package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.adapters.in.api.dto.TicketBuyDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketResponseDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketsPurchasedDto;
import com.djoseffer.onticket.application.service.TicketService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @PostMapping("/{eventId}/create")
    public ResponseEntity<TicketResponseDto> createTicket(@PathVariable String eventId, @RequestBody TicketRequestDto ticketRequestDto) {
        return ResponseEntity.ok(ticketService.createTicket(eventId, ticketRequestDto));
    }

    @GetMapping("/{eventId}")
    public ResponseEntity<List<TicketResponseDto>> getTicketByEvent(@PathVariable String eventId) {
        return ResponseEntity.ok(ticketService.findTicketsByEvent(eventId));
    }

    @PostMapping("/{eventId}/buy")
    public ResponseEntity<TicketsPurchasedDto> ticketBuyEvent(@PathVariable String eventId, @RequestBody TicketBuyDto ticketBuy) {
        return ResponseEntity.status(HttpStatus.OK).body(ticketService.ticketBuy(eventId, ticketBuy));
    }

}
