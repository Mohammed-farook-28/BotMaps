package com.bot.travel.services;

import java.util.ArrayList;
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
            userCountry.setPhotoUrls(new ArrayList<>());
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
            userCountry.setPeopleMet(new ArrayList<>());
        }
        userCountry.getPeopleMet().add(person);
        return userCountryRepository.save(userCountry);
    }

    public List<UserCountry.Person> getAllPeopleMet(String userId) {
        List<UserCountry> userCountries = userCountryRepository.findByUserId(userId);
        List<UserCountry.Person> allPeople = new ArrayList<>();
        for (UserCountry userCountry : userCountries) {
            if (userCountry.getPeopleMet() != null) {
                allPeople.addAll(userCountry.getPeopleMet());
            }
        }
        return allPeople;
    }

    public List<UserCountry.Person> getPeopleByUserAndNationality(String userId, String nationality) {
        List<UserCountry> userCountries = userCountryRepository.findByUserId(userId);
        List<UserCountry.Person> filteredPeople = new ArrayList<>();
        for (UserCountry userCountry : userCountries) {
            if (userCountry.getPeopleMet() != null) {
                for (UserCountry.Person person : userCountry.getPeopleMet()) {
                    if (person.getNationality().equalsIgnoreCase(nationality)) {
                        filteredPeople.add(person);
                    }
                }
            }
        }
        return filteredPeople;
    }
    
}
