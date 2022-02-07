package com.accenture.villakunterbunt.julias_travels.entities;

import com.accenture.villakunterbunt.julias_travels.YearAttributeConverter;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.time.Year;
import java.util.Set;

@Entity
@Table(name="countries")
public class Country {

    @Id
    @Column(name="country_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="country_name")
    private String name;

    @Column(name="country_continent")
    private String continent;

    @Column(name="country_year_visited")
    @Convert(converter = YearAttributeConverter.class)
    private Year yearVisited;

    @OneToMany(mappedBy = "country", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Place> places;

    protected Country() {}

    public Country(String name, String continent, Year yearVisited) {
        this.name = name;
        this.continent = continent;
        this.yearVisited = yearVisited;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public Year getYearVisited() {
        return yearVisited;
    }

    public void setYearVisited(Year yearVisited) {
        this.yearVisited = yearVisited;
    }

    @JsonManagedReference
    public Set<Place> getPlaces() {
        return places;
    }

    public void setPlaces(Set<Place> places) {
        this.places = places;
    }
}
