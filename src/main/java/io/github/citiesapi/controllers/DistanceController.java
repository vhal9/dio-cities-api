package io.github.citiesapi.controllers;

import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.models.DTO.DistanceRequestDTO;
import io.github.citiesapi.services.DistanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ditances")
public class DistanceController {

    @Autowired
    private DistanceService distanceService;

    @GetMapping("/by-points")
    public Double byPoint(@RequestBody final DistanceRequestDTO distanceRequestDTO) throws CityNotFoundException {

        return distanceService.distanceByPointInMillis(distanceRequestDTO);

    }

    @GetMapping("/by-cube")
    public Double byCube(@RequestBody final DistanceRequestDTO distanceRequestDTO) throws CityNotFoundException {

        return distanceService.distanceByCube(distanceRequestDTO);

    }



}
