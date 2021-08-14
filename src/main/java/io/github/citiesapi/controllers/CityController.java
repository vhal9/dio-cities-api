package io.github.citiesapi.controllers;

import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.models.City;
import io.github.citiesapi.services.CityServices;
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
@RequestMapping("api/v1/cities")
public class CityController {

    @Autowired
    private CityServices cityServices;

    @GetMapping
    public Page<City> listCities(
            @PageableDefault(sort = "name",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 5)
            Pageable page) {

        return cityServices.listCities(page);

    }

    @GetMapping("/{id}")
    public City findCity(@PathVariable Long id) throws CityNotFoundException {

        return cityServices.findCity(id);

    }

}
