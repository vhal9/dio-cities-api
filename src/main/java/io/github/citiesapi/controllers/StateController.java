package io.github.citiesapi.controllers;

import io.github.citiesapi.models.State;
import io.github.citiesapi.services.StateServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/states")
public class StateController {

    @Autowired
    private StateServices stateServices;

    @GetMapping
    public Page<State> staties(
            @PageableDefault(sort = "name",
                    direction = Sort.Direction.ASC,
                    page = 0,
                    size = 5)
                    Pageable page) {

        return stateServices.listStates(page);

    }
}
