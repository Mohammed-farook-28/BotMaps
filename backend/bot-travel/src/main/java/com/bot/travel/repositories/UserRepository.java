package com.bot.travel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bot.travel.models.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
    User findByUserId(String userId);
}
