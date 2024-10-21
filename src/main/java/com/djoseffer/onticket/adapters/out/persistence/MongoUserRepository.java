package com.djoseffer.onticket.adapters.out.persistence;

import com.djoseffer.onticket.domain.User;
import com.djoseffer.onticket.domain.repository.UserRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MongoUserRepository implements UserRepository {
    private final MongoTemplate mongoTemplate;

    public MongoUserRepository(MongoTemplate mongoTemplate){
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(User user) {
        mongoTemplate.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(mongoTemplate.findById(id, User.class));
    }

    @Override
    public Optional<User> findByEmail(String email){
        return Optional.ofNullable(mongoTemplate.findOne(Query.query(Criteria.where("email").is(email)), User.class));
    }

}
