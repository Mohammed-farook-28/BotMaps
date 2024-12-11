package com.bot.travel.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bot.travel.models.Country;

@Repository
public interface CountryRepository extends MongoRepository<Country, String>{
    Country findByCode(String code);
}
