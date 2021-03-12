package com.lambdaschool.countries.repositories;

import com.lambdaschool.countries.models.Country;
import org.springframework.data.repository.CrudRepository;
//connects the rest of the java application to the country table

public interface CountryRepository extends CrudRepository<Country, Long>
{
}
