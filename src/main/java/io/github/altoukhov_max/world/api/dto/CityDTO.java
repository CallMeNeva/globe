package io.github.altoukhov_max.world.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CityDTO(@JsonProperty("name") String name,
                      @JsonProperty("country") String countryName,
                      @JsonProperty("district") String districtName,
                      @JsonProperty("population") int populationCount) {
}
