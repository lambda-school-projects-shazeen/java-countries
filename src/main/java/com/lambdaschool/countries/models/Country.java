package com.lambdaschool.countries.models;

import javax.persistence.Id;

public class Country
{

    @Id

    private String name;
    private long population;
    private long landmasskm2;
    private int medianage;

    public Country()
    {
        //default
    }

    public Country(
        String name,
        long population,
        long landmasskm2,
        int medianage)
    {
        this.name = name;
        this.population = population;
        this.landmasskm2 = landmasskm2;
        this.medianage = medianage;
    }
}
