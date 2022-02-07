package com.accenture.villakunterbunt.julias_travels.repositories;

import com.accenture.villakunterbunt.julias_travels.entities.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.time.Year;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByNameIgnoreCase(String name);

    Iterable<Country> findByYearVisited(Year year);

}
