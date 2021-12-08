package io.github.altoukhov_max.world.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record LanguageDTO(@JsonProperty("name") String name,
                          @JsonProperty("country") String countryName,
                          @JsonProperty("official") boolean official,
                          @JsonProperty("percentage") float percentage) {
}
