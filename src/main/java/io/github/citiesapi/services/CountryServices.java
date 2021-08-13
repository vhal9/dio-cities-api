package io.github.citiesapi.services;

import io.github.citiesapi.exceptions.CountryNotFoundException;
import io.github.citiesapi.models.Country;
import io.github.citiesapi.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CountryServices {

    @Autowired
    CountryRepository countryRepository;

    public Page<Country> listCountries(Pageable page) {

        return countryRepository.findAll(page);

    }

    public Country getCountry(Long id) throws CountryNotFoundException {

        Country country = countryRepository.findById(id)
                .orElseThrow(() -> new CountryNotFoundException(id));

        return country;

    }
}
