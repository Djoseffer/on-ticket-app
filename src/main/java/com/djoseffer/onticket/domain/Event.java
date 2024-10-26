package com.djoseffer.onticket.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "events_tb")
public class Event implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String eventName;
    private String eventDescription;
    private LocalDateTime date;
    @DBRef
    private User creator;
    private Long ticketQuantity;
    private BigDecimal ticketPrice;
    @DBRef
    private List<Ticket> eventTickets;

    public void addTicket(Ticket ticket) {

    }

    public boolean isSoldOut;
}
