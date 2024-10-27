package com.djoseffer.onticket.application.serviceImpl;

import com.djoseffer.onticket.adapters.in.api.dto.EventRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.EventResponseDto;

import java.util.List;

public interface EventServiceImpl {

    void createEvent(EventRequestDto eventRequestDto);

    List<EventResponseDto> findAllEvents();

    List<EventResponseDto> findEventById(String userId);
}
