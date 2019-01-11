package com.chrisgruber.nanourl.repositories;

import com.chrisgruber.nanourl.models.Counter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CounterRepository extends MongoRepository<Counter, String> {
}
