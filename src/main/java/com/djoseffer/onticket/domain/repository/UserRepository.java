package com.djoseffer.onticket.domain.repository;

import com.djoseffer.onticket.domain.User;

import java.util.Optional;

public interface UserRepository {
    void save (User user);
    Optional<User> findById(Long id);
    Optional<User> findByEmail (String email);
}
