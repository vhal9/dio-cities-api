package io.github.citiesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CityNotFoundException extends Exception {
    public CityNotFoundException(Long id) {
        super(String.format("City with ID %s not found in the system ", id));
    }
}
