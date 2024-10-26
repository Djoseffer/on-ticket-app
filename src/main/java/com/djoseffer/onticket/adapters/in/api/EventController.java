package com.djoseffer.onticket.adapters.in.api;

import com.djoseffer.onticket.adapters.in.api.dto.EventRequestDto;
import com.djoseffer.onticket.adapters.in.api.dto.EventResponseDto;
import com.djoseffer.onticket.application.service.EventService;
import com.djoseffer.onticket.domain.Event;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {
    private final EventService eventService;

    public EventController(final EventService eventService) {
        this.eventService = eventService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createEvent(@RequestBody @Valid final EventRequestDto eventDto) {
        eventService.createEvent(eventDto);
        return ResponseEntity.ok("Event created");
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<EventResponseDto>> getAllEventsByUser(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findEventById(id));
    }

    @GetMapping()
    public ResponseEntity<List<EventResponseDto>> getAllEvents() {
        return ResponseEntity.status(HttpStatus.OK).body(eventService.findAllEvents());
    }

}
