package com.djoseffer.onticket.domain;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private List<Ticket> tickets;

    public void createEvent(Event event) {
    }

    public void buyTicket(Ticket ticket) {
    }
}
