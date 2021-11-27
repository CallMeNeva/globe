package io.github.altoukhovmax.worldapi.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.altoukhovmax.worldapi.entity.Language;

public record LanguageDTO(@JsonProperty("name") String name,
                          @JsonProperty("country") String countryName,
                          @JsonProperty("official") boolean official,
                          @JsonProperty("percentage") float percentage) {

    public LanguageDTO(Language language) {
        this(language.getName(),
             language.getCountry().getName(),
             language.isOfficial(),
             language.getPercentage());
    }
}
