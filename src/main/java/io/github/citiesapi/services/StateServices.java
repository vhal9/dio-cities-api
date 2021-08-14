package io.github.citiesapi.services;

import io.github.citiesapi.models.State;
import io.github.citiesapi.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class StateServices {

    @Autowired
    private StateRepository stateRepository;

    public Page<State> listStates(Pageable page) {

        return stateRepository.findAll(page);

    }
}
