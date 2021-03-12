package com.lambdaschool.countries.controllers;

import com.lambdaschool.countries.models.Country;
import com.lambdaschool.countries.repositories.CountryRepository;
import org.hibernate.annotations.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountryController
{
//    connects this class to the country repository
    @Autowired
    CountryRepository countryrepo;

    //http://localhost:2019/population/total
    @GetMapping(value = "/population/total", produces = {"application/json"})
    public ResponseEntity<?> findLargerPopulation()
    {
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll()
            .iterator()
            .forEachRemaining(myList::add);
        long total = 0;

        for (Country c : myList)
        {
            total = total + c.getPopulation();
        }
        System.out.println("The total population is " + total);
        return new ResponseEntity<>(myList, HttpStatus.OK);
    }

    @GetMapping(value = "/population/min", produces = {"application/json"})
    public ResponseEntity<?> findMinPopulation()
    {
        List<Country> myList = new ArrayList<>();
        countryrepo.findAll().iterator().forEachRemaining(myList::add);

        myList.sort((c1,c2) -> (int)(c1.getPopulation() - c2.getPopulation()));

        Country rntCountry = myList.get(0);
        return new ResponseEntity<>(rntCountry, HttpStatus.OK);
    }
}
