package com.accenture.villakunterbunt.julias_travels.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="places")
public class Place {

    @Id
    @Column(name="place_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name="place_name")
    private String name;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_country")
    private Country country;

    protected Place() {
    }

    public Place(String name) {
        this.name = name;
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


    public void setCountry(Country country) {
        this.country = country;
    }

    @JsonBackReference
    public Country getCountry() {
        return country;
    }

}
