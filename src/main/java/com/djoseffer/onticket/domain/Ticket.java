package com.djoseffer.onticket.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

@Document(collection = "tickets_tb")
public class Ticket implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private BigDecimal price;
    private String description;
    private String local;
    @DBRef
    private Event event;
    @DBRef
    private User creator;
}
