package com.djoseffer.onticket.application.service.mapper;

import com.djoseffer.onticket.adapters.in.api.dto.TicketBuyDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketResponseDto;
import com.djoseffer.onticket.adapters.in.api.dto.TicketsPurchasedDto;
import com.djoseffer.onticket.domain.Event;
import com.djoseffer.onticket.domain.Ticket;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.math.BigDecimal;

@Mapper(componentModel = "spring")
public interface TicketMapper {

    TicketMapper INSTANCE = Mappers.getMapper(TicketMapper.class);

    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "local", source = "local")
    TicketResponseDto converTicketToTicketResponseDto(Ticket ticket);

    @Mapping(target = "price", source = "price")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "local", source = "local")
    Ticket converTicketRequestDtoToTicket(TicketRequestDto ticket);

    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "ticketQuantity", source = "ticketQuantity")
    Event convertTickebuyDtoToTicket(TicketBuyDto ticketBuyDto);

    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "ticketQuantity", source = "ticketQuantity")
    @Mapping(target = "totalValue", expression = "java(calculateTotalValue(eventTicket.getTicketPrice(), eventTicket.getTicketQuantity()))")
    @Mapping(target = "message", expression = "java(generateMessage(ticketQuantity))")
    TicketsPurchasedDto convertTicketPurchaseDtoToTicket(Event eventTicket);


    default BigDecimal calculateTotalValue(BigDecimal price, Long ticketQuantity) {
        return price.multiply(BigDecimal.valueOf(ticketQuantity));
    }

    default String generateMessage(Long ticketQuantity) {
        return "Compra de " + ticketQuantity + " ingressos confirmada!";
    }
}
