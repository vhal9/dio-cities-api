package io.github.citiesapi.services;

import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.models.City;
import io.github.citiesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityServices {

    @Autowired
    private CityRepository cityRepository;

    public Page<City> listCities(Pageable page) {

        return cityRepository.findAll(page);

    }

    public City findCity(Long id) throws CityNotFoundException {

        City city = cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));

        return city;

    }

    public void verifyIfCityExist(Long id) throws CityNotFoundException {

        cityRepository.findById(id)
                .orElseThrow(() -> new CityNotFoundException(id));

    }

}
