package com.djoseffer.onticket.domain.repository;

import com.djoseffer.onticket.domain.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository {
    void save (User user);
    Optional<User> findById(String id);
    Optional<User> findByEmail (String email);
}
