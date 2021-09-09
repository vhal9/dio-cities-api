package io.github.citiesapi.controllers;

import io.github.citiesapi.exceptions.ApiErros;
import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.exceptions.CountryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleMethodArgumentNotValidException( MethodArgumentNotValidException ex) {

        List<String> erros = ex.getBindingResult().getAllErrors()
                .stream()
                .map( erro -> erro.getDefaultMessage())
                .collect(Collectors.toList());

        return new ApiErros(erros);


    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiErros handleHttpMessageNotReadableException( HttpMessageNotReadableException ex) {

        return new ApiErros(ex.getMessage());

    }
}
