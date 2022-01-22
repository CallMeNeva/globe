package com.altoukhov.globe.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String countryName;

    @JsonProperty("district")
    private String districtName;

    @JsonProperty("population")
    private int populationCount;
}
