package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.adapters.in.api.dto.TicketBuyDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketResponseDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketsPurchasedDto;

import java.util.List;

public interface TicketServiceImpl {

    List<TicketResponseDto> findTicketsByEvent(String eventId);

    TicketResponseDto createTicket(String eventId, TicketRequestDto ticketDto);

    TicketsPurchasedDto ticketBuy(String eventId, TicketBuyDto ticket);

}

