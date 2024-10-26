package com.djoseffer.onticket.application.service;

import com.djoseffer.onticket.adapters.in.api.dto.EventRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.EventResponseDto;
import com.djoseffer.onticket.adapters.out.persistence.MongoEventRepository;
import com.djoseffer.onticket.adapters.out.persistence.MongoUserRepository;
import com.djoseffer.onticket.application.service.mapper.EventMapper;
import com.djoseffer.onticket.application.serviceImpl.EventServiceImpl;
import com.djoseffer.onticket.domain.Event;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class EventService implements EventServiceImpl {

    private final MongoEventRepository mongoEventRepository;
    private final MongoUserRepository mongoUserRepository;
    private final AuthService authService;

    public EventService(MongoEventRepository mongoEventRepository, MongoUserRepository mongoUserRepository, AuthService authService) {
        this.mongoEventRepository = mongoEventRepository;
        this.mongoUserRepository = mongoUserRepository;
        this.authService = authService;
    }

    @Override
    public void createEvent(EventRequestDto eventRequestDto) {
        Event newEvent = EventMapper.INSTANCE.convertEventRequestDtotoEvent(eventRequestDto);
        newEvent.setDate(LocalDateTime.now());
        var authentication = SecurityContextHolder.getContext().getAuthentication();
        Jwt jwtToken = (Jwt) authentication.getCredentials();
        String userId = authService.extractUserIdFromToken(jwtToken.getTokenValue());
        mongoUserRepository.findById(userId)
                .map(userFound -> {
                    newEvent.setCreator(userFound);
                    return userFound;
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
        mongoEventRepository.save(newEvent);
    }


    @Override
    public List<EventResponseDto> findAllEvents() {
        List<Event> events = mongoEventRepository.findAll();
        return events.stream()
                .map(EventMapper.INSTANCE::convertEventToEventResponseDto)
                .toList();
    }

    @Override
    public List<EventResponseDto> findEventById(String userId) {
        List<Event> events = mongoEventRepository.findEventByUserId(userId);
        return events.stream()
                .map(EventMapper.INSTANCE::convertEventToEventResponseDto)
                .toList();
    }
}
