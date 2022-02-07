package com.accenture.villakunterbunt.julias_travels;

import com.accenture.villakunterbunt.julias_travels.entities.Country;
import com.accenture.villakunterbunt.julias_travels.entities.Place;
import com.accenture.villakunterbunt.julias_travels.repositories.CountryRepository;
import com.accenture.villakunterbunt.julias_travels.repositories.PlaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlaceRestController {

    CountryRepository countryRepository;
    PlaceRepository placeRepository;

    @Autowired
    public PlaceRestController(CountryRepository countryRepository, PlaceRepository placeRepository) {
        this.countryRepository = countryRepository;
        this.placeRepository = placeRepository;
    }

    @GetMapping("/{country}/places")
    public Iterable<Place> readPlacesByCountry(@PathVariable("country") String countryName) {
        Country country = countryRepository.findByNameIgnoreCase(countryName);
        return placeRepository.findByCountry(country);
    }


}
