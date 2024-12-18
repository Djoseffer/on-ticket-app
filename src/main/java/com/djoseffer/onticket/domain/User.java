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
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "users_tb")
public class User implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    @DBRef
    private List<Event> tickets;
}

