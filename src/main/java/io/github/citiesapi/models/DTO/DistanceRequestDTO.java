package io.github.citiesapi.models.DTO;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class DistanceRequestDTO {

    @NotNull(message = " Id origin city field is required ")
    private Long idCityOrigin;

    @NotNull(message = "Id destiny city field is required")
    private Long idCityDestiny;

}
