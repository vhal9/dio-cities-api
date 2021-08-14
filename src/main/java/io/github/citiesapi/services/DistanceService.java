package io.github.citiesapi.services;

import io.github.citiesapi.exceptions.CityNotFoundException;
import io.github.citiesapi.models.City;
import io.github.citiesapi.models.DTO.DistanceRequestDTO;
import io.github.citiesapi.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class DistanceService {

    @Autowired
    private CityServices cityServices;

    @Autowired
    private CityRepository cityRepository;

    public Double distanceByPointInMillis(DistanceRequestDTO distanceRequestDTO) throws CityNotFoundException {

        cityServices.verifyIfCityExist(distanceRequestDTO.getIdCityOrigin());
        cityServices.verifyIfCityExist(distanceRequestDTO.getIdCityDestiny());

        return cityRepository.distanceByPoints(distanceRequestDTO.getIdCityOrigin(),
                distanceRequestDTO.getIdCityDestiny());
    }

    public Double distanceByCube(DistanceRequestDTO distanceRequestDTO) throws CityNotFoundException {

        City cityOrigin = cityServices.findCity(distanceRequestDTO.getIdCityOrigin());
        City cityDestiny = cityServices.findCity(distanceRequestDTO.getIdCityDestiny());

        return cityRepository.distanceByCube(cityOrigin.getLocation().getX(), cityOrigin.getLocation().getY(),
                cityDestiny.getLocation().getX(), cityDestiny.getLocation().getY());

    }
}
