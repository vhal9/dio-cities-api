package io.github.citiesapi.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CountryNotFoundException extends Exception {

    public CountryNotFoundException(Long id) {
        super(String.format("Country with ID %s not found in the system ",id));
    }
}
