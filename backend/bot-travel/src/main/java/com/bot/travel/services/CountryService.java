package com.bot.travel.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bot.travel.models.Country;
import com.bot.travel.repositories.CountryRepository;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    public Country getCountryByCode(String code) {
        return countryRepository.findByCode(code);
    }

    public Country addCountry(Country country) {
        return countryRepository.save(country);
    }

    public Country updateCountry(String code, Country updatedCountry) {
        Country existingCountry = countryRepository.findByCode(code);
        if (existingCountry != null) {
            updatedCountry.setId(existingCountry.getId());
            return countryRepository.save(updatedCountry);
        }
        return null;
    }

    public void deleteCountry(String code) {
        Country existingCountry = countryRepository.findByCode(code);
        if (existingCountry != null) {
            countryRepository.delete(existingCountry);
        }
    }
}
