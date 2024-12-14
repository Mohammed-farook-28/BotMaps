package com.bot.travel.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bot.travel.models.UserCountry;
import com.bot.travel.services.UserCountryService;

@RestController
@RequestMapping("/user-countries")
public class UserCountryController {

    @Autowired
    private UserCountryService userCountryService;

    @GetMapping("/{userId}/visited")
    public List<UserCountry> getVisitedCountries(@PathVariable String userId) {
        return userCountryService.getVisitedCountries(userId);
    }

    @PatchMapping("/{userId}/toggle/{countryCode}")
    public UserCountry toggleVisited(@PathVariable String userId, @PathVariable String countryCode) {
        return userCountryService.toggleVisited(userId, countryCode);
    }

    @PatchMapping("/{userId}/{countryCode}/notes")
    public UserCountry addOrUpdateNotes(@PathVariable String userId, @PathVariable String countryCode, @RequestBody String notes) {
        return userCountryService.addOrUpdateNotes(userId, countryCode, notes);
    }

    @PostMapping("/{userId}/{countryCode}/photos")
    public UserCountry addPhoto(@PathVariable String userId, @PathVariable String countryCode, @RequestBody String photoUrl) {
        return userCountryService.addPhoto(userId, countryCode, photoUrl);
    }

    @PostMapping("/{userId}/{countryCode}/people")
    public UserCountry addPersonMet(@PathVariable String userId, @PathVariable String countryCode, @RequestBody UserCountry.Person person) {
        return userCountryService.addPersonMet(userId, countryCode, person);
    }

    @GetMapping("/{userId}/people")
    public List<UserCountry.Person> getAllPeopleMet(@PathVariable String userId) {
        return userCountryService.getAllPeopleMet(userId);
    }

    @GetMapping("/filter/nationality/{userId}/{nationality}")
    public List<UserCountry.Person> getPeopleByUserAndNationality(
            @PathVariable String userId,
            @PathVariable String nationality) {
        return userCountryService.getPeopleByUserAndNationality(userId, nationality);
    }
}
