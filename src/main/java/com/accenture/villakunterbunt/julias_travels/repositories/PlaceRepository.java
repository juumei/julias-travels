package com.accenture.villakunterbunt.julias_travels.repositories;

import com.accenture.villakunterbunt.julias_travels.entities.Country;
import com.accenture.villakunterbunt.julias_travels.entities.Place;
import org.springframework.data.repository.CrudRepository;

public interface PlaceRepository extends CrudRepository<Place, Long> {

    Iterable<Place> findByCountry(Country country);

    Place findByNameIgnoreCase(String placeName);



}
