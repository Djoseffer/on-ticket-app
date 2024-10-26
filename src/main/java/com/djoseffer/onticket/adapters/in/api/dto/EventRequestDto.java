package com.djoseffer.onticket.adapters.in.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record EventRequestDto(
        @NotBlank(message = "Event name is mandatory")
        String eventName,
        @NotBlank(message = "Description is mandatory")
        String eventDescription,
        @NotNull(message = "Ticket price is mandatory")
        @DecimalMin(value = "0.0", inclusive = false, message = "Ticket price")
        BigDecimal ticketPrice,
        @NotNull(message = "Ticket quantity is mandatory")
        @Min(value = 1, message = "At least one ticket must be available")
        Long ticketQuantity
        ) {
}
