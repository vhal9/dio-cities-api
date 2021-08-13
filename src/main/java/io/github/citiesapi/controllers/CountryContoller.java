package io.github.citiesapi.controllers;

import io.github.citiesapi.exceptions.CountryNotFoundException;
import io.github.citiesapi.models.Country;
import io.github.citiesapi.services.CountryServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/countries")
public class CountryContoller {

    @Autowired
    CountryServices countryServices;

    @GetMapping
    public Page<Country> listCountries(
            @PageableDefault(sort = "name",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 10)
                    Pageable page){

        return countryServices.listCountries(page);

    }

    @GetMapping("/{id}")
    public Country getCountry(@PathVariable Long id) throws CountryNotFoundException {

        return countryServices.getCountry(id);

    }

}
