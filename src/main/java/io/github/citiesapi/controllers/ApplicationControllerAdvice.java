package io.github.citiesapi.controllers;

import io.github.citiesapi.exceptions.ApiErros;
import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.exceptions.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApplicationControllerAdvice {

    @ExceptionHandler(CityNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleCityNotFoundException(CityNotFoundException ex) {

        return new ApiErros(ex.getMessage());

    }

    @ExceptionHandler(CountryNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleCountryNotFoundException(CountryNotFoundException ex) {

        return new ApiErros(ex.getMessage());

    }
}
