package com.chrisgruber.nanourl.repositories;

import com.chrisgruber.nanourl.models.UserProfile;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserProfileRepository extends MongoRepository<UserProfile, String> {
    UserProfile findById(int id);
    UserProfile findByEmail(String email);
}