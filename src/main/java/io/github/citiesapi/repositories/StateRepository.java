package io.github.citiesapi.repositories;

import io.github.citiesapi.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State, Long> {
}
