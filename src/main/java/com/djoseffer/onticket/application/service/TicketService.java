package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.adapters.in.api.dto.TicketBuyDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketResponseDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketsPurchasedDto;
import com.djoseffer.onticket.adapters.out.persistence.MongoEventRepository;
import com.djoseffer.onticket.adapters.out.persistence.MongoTicketRepository;
import com.djoseffer.onticket.adapters.out.persistence.MongoUserRepository;
import com.djoseffer.onticket.application.service.mapper.TicketMapper;
import com.djoseffer.onticket.application.serviceImpl.TicketServiceImpl;
import com.djoseffer.onticket.domain.Event;
import com.djoseffer.onticket.domain.Ticket;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements TicketServiceImpl {

    private final MongoTicketRepository ticketRepository;
    private final MongoEventRepository eventRepository;
    private final AuthService authService;
    private final MongoUserRepository userRepository;

    public TicketService(MongoTicketRepository ticketRepository, MongoEventRepository eventRepository, AuthService authService, MongoUserRepository userRepository) {
        this.ticketRepository = ticketRepository;
        this.eventRepository = eventRepository;
        this.authService = authService;
        this.userRepository = userRepository;
    }

    private String getUserByToken() {
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwtToken = (Jwt) authentication.getCredentials();
        return authService.extractUserIdFromToken(jwtToken.getTokenValue());
    }

    @Override
    public List<TicketResponseDto> findTicketsByEvent(String eventId) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new IllegalArgumentException("Event not found"));

        return event.getEventTickets().stream()
                .map(TicketMapper.INSTANCE::converTicketToTicketResponseDto)
                .toList();
    }

    @Override
    public TicketResponseDto createTicket(String eventId, TicketRequestDto ticket) {
        var event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        var newTicket = TicketMapper.INSTANCE.converTicketRequestDtoToTicket(ticket);
        newTicket.setEvent(event);
        userRepository.findById(getUserByToken())
                .map(userFound -> {
                    newTicket.setCreator(userFound);
                    return userFound;
                }).orElseThrow(() -> new RuntimeException("User not found"));
        event.getEventTickets().add(newTicket);
        ticketRepository.save(newTicket);
        eventRepository.save(event);
        return TicketMapper.INSTANCE.converTicketToTicketResponseDto(newTicket);
    }

    public TicketsPurchasedDto ticketBuy(String eventId, TicketBuyDto ticketBuy) {
        Event event = eventRepository.findById(eventId).orElseThrow(() -> new RuntimeException("Event not found"));
        Event ticket = TicketMapper.INSTANCE.convertTickebuyDtoToTicket(ticketBuy);
        ticket.setEventName(event.getEventName());
        ticket.setTicketPrice(event.getTicketPrice());
        return TicketMapper.INSTANCE.convertTicketPurchaseDtoToTicket(ticket);
    }
}
