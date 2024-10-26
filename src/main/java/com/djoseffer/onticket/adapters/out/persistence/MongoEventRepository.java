package com.djoseffer.onticket.adapters.out.persistence;

import com.djoseffer.onticket.domain.Event;
import com.djoseffer.onticket.domain.repository.EventRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MongoEventRepository implements EventRepository {
    private final MongoTemplate mongoTemplate;

    public MongoEventRepository(final MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void save(Event event) {
        mongoTemplate.save(event);
    }

    @Override
    public Optional<Event> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Event.class));
    }

    @Override
    public List<Event> findAll() {
        return mongoTemplate.findAll(Event.class);
    }

    @Override
    public List<Event> findEventByUserId(String userId) {
        return List.of();
    }

}
