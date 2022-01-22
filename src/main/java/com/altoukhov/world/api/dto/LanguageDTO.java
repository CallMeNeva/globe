package com.altoukhov.world.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class LanguageDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("country")
    private String countryName;

    @JsonProperty("official")
    private boolean official;

    @JsonProperty("percentage")
    private float percentage;
}
