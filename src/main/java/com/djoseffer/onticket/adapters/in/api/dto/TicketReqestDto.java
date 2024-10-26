package com.djoseffer.onticket.adapters.in.api.dto;

import java.math.BigDecimal;

public record TicketReqestDto(
        BigDecimal price,
        String description,
        String local,
        String eventId
) {
}
