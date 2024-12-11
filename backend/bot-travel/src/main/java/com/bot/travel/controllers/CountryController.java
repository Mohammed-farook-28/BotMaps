package com.bot.travel.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.bot.travel.models.Country;
import com.bot.travel.services.CountryService;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries() {
        return countryService.getAllCountries();
    }

    @GetMapping("/{code}")
    public Country getCountryByCode(@PathVariable String code) {
        return countryService.getCountryByCode(code);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country) {
        return countryService.addCountry(country);
    }

    @PutMapping("/{code}")
    public Country updateCountry(@PathVariable String code, @RequestBody Country updatedCountry) {
        return countryService.updateCountry(code, updatedCountry);
    }

    @DeleteMapping("/{code}")
    public String deleteCountry(@PathVariable String code) {
        countryService.deleteCountry(code);
        return "Country with code " + code + " has been deleted successfully.";
    }
}
