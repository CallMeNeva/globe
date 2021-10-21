package io.github.altoukhovmax.sampleworldapi.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.altoukhovmax.sampleworldapi.model.City;

public record CityDTO(@JsonProperty("name") String name,
                      @JsonProperty("country") String countryName,
                      @JsonProperty("district") String districtName,
                      @JsonProperty("population") int populationCount) {

    public CityDTO(City city) {
        this(city.getName(),
             city.getCountry().getName(),
             city.getDistrictName(),
             city.getPopulationCount());
    }
}
