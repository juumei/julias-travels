package com.accenture.villakunterbunt.julias_travels;

import com.accenture.villakunterbunt.julias_travels.entities.Country;
import com.accenture.villakunterbunt.julias_travels.entities.Place;
import com.accenture.villakunterbunt.julias_travels.repositories.CountryRepository;
import com.accenture.villakunterbunt.julias_travels.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.Year;
import java.util.List;

@RestController
public class CountryRestController {

    CountryRepository countryRepository;
    PlaceRepository placeRepository;

    @Autowired
    public CountryRestController(CountryRepository countryRepository, PlaceRepository placeRepository) {
        this.countryRepository = countryRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/countries")
    public Iterable<Country> readCountries(@RequestParam(name="year", required = false) Year year) {
        if (year == null) {
            return countryRepository.findAll();
        } else {
            return countryRepository.findByYearVisited(year);
        }
    }

    @GetMapping("/{country}")
    public Country readCountryByName(@PathVariable("country") String countryName) {
        return countryRepository.findByNameIgnoreCase(countryName);
    }

    @GetMapping("/countries/{id}")
    public Country readCountryById(@PathVariable("id") Long id) {
        if (countryRepository.findById(id).isPresent()) {
            return countryRepository.findById(id).get();
        }
        return null;
    }

    @PostMapping("/countries")
    public void createCountry(@RequestBody Country country) {
        countryRepository.save(country);
    }


}
