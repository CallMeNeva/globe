package io.github.altoukhovmax.worldapi.web.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.altoukhovmax.worldapi.model.Country;

import java.math.BigDecimal;
import java.time.Year;

public record CountryDTO(@JsonProperty("name") String name,
                         @JsonProperty("localName") String localName,
                         @JsonProperty("alpha2Code") String alpha2Code,
                         @JsonProperty("capital") String capitalName,
                         @JsonProperty("continent") String continentName,
                         @JsonProperty("region") String regionName,
                         @JsonProperty("surfaceArea") BigDecimal surfaceArea,
                         @JsonProperty("governmentForm") String governmentFormName,
                         @JsonProperty("headOfState") String headOfStateName,
                         @JsonProperty("independenceYear") Year independenceYear,
                         @JsonProperty("population") int populationCount,
                         @JsonProperty("lifeExpectancy") Float lifeExpectancy, // See related comment in entity class
                         @JsonProperty("GNP") BigDecimal grossNationalProduct,
                         @JsonProperty("oldGNP") BigDecimal oldGrossNationalProduct) {

    public CountryDTO(Country country) {
        this(country.getName(),
             country.getLocalName(),
             country.getAlpha2Code(),
             country.getCapital() == null ? null : country.getCapital().getName(),
             country.getContinent().getDisplayName(),
             country.getRegionName(),
             country.getSurfaceArea(),
             country.getGovernmentFormName(),
             country.getHeadOfStateName(),
             country.getIndependenceYear(),
             country.getPopulationCount(),
             country.getLifeExpectancy(),
             country.getGrossNationalProduct(),
             country.getOldGrossNationalProduct());
    }
}
