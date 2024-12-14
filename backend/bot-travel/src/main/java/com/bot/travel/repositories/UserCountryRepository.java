package com.bot.travel.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bot.travel.models.UserCountry;

@Repository
public interface UserCountryRepository extends MongoRepository<UserCountry, String> {

    List<UserCountry> findByUserId(String userId);

    UserCountry findByUserIdAndCountryCode(String userId, String countryCode);

    List<UserCountry> findByUserIdAndPeopleMetIsNotNull(String userId);

    List<UserCountry> findByUserIdAndPeopleMetNationality(String userId, String nationality);
}
