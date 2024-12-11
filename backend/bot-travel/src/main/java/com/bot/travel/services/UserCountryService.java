package com.bot.travel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bot.travel.models.UserCountry;
import com.bot.travel.repositories.UserCountryRepository;

@Service
public class UserCountryService {

    @Autowired
    private UserCountryRepository userCountryRepository;

    public List<UserCountry> getVisitedCountries(String userId) {
        return userCountryRepository.findByUserId(userId).stream()
            .filter(UserCountry::isVisited)
            .toList();
    }

    public UserCountry toggleVisited(String userId, String countryCode) {
        UserCountry userCountry = userCountryRepository.findByUserIdAndCountryCode(userId, countryCode);
        if (userCountry == null) {
            userCountry = new UserCountry();
            userCountry.setUserId(userId);
            userCountry.setCountryCode(countryCode);
            userCountry.setVisited(true);
        } else {
            userCountry.setVisited(!userCountry.isVisited());
        }
        return userCountryRepository.save(userCountry);
    }

    public UserCountry addOrUpdateNotes(String userId, String countryCode, String notes) {
        UserCountry userCountry = userCountryRepository.findByUserIdAndCountryCode(userId, countryCode);
        if (userCountry == null) {
            userCountry = new UserCountry();
            userCountry.setUserId(userId);
            userCountry.setCountryCode(countryCode);
        }
        userCountry.setNotes(notes);
        return userCountryRepository.save(userCountry);
    }

    public UserCountry addPhoto(String userId, String countryCode, String photoUrl) {
        UserCountry userCountry = userCountryRepository.findByUserIdAndCountryCode(userId, countryCode);
        if (userCountry == null) {
            userCountry = new UserCountry();
            userCountry.setUserId(userId);
            userCountry.setCountryCode(countryCode);
        }
        if (userCountry.getPhotoUrls() == null) {
            userCountry.setPhotoUrls(new java.util.ArrayList<>());
        }
        userCountry.getPhotoUrls().add(photoUrl);
        return userCountryRepository.save(userCountry);
    }

    public UserCountry addPersonMet(String userId, String countryCode, UserCountry.Person person) {
        UserCountry userCountry = userCountryRepository.findByUserIdAndCountryCode(userId, countryCode);
        if (userCountry == null) {
            userCountry = new UserCountry();
            userCountry.setUserId(userId);
            userCountry.setCountryCode(countryCode);
        }
        if (userCountry.getPeopleMet() == null) {
            userCountry.setPeopleMet(new java.util.ArrayList<>());
        }
        userCountry.getPeopleMet().add(person);
        return userCountryRepository.save(userCountry);
    }
}
