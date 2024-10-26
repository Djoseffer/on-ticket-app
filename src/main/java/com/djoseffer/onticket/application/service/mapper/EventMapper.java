package com.djoseffer.onticket.application.service.mapper;

import com.djoseffer.onticket.adapters.in.api.dto.EventRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.EventResponseDto;
import com.djoseffer.onticket.domain.Event;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface EventMapper {

    EventMapper INSTANCE = Mappers.getMapper(EventMapper.class);

    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "eventDescription", source = "eventDescription")
    @Mapping(target = "ticketPrice", source = "ticketPrice")
    @Mapping(target = "ticketQuantity", source = "ticketQuantity")
    Event convertEventRequestDtotoEvent(EventRequestDto eventRequestDto);

    @Mapping(target = "eventName", source = "eventName")
    @Mapping(target = "eventDescription", source = "eventDescription")
    @Mapping(target = "creator", source = "creator")
    @Mapping(target = "ticketPrice", source = "ticketPrice")
    @Mapping(target = "ticketQuantity", source = "ticketQuantity")
    EventResponseDto convertEventToEventResponseDto(Event event);
}
