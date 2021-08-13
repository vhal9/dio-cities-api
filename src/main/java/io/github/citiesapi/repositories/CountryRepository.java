package io.github.citiesapi.repositories;

import io.github.citiesapi.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {}
