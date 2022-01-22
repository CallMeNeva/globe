package com.altoukhov.globe.country;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.Year;

@Getter
@Setter
@NoArgsConstructor
public class CountryDTO {

    @JsonProperty("name")
    private String name;

    @JsonProperty("localName")
    private String localName;

    @JsonProperty("alpha2")
    private String alpha2Code;

    @JsonProperty("capital")
    private String capitalName;

    @JsonProperty("continent")
    private String continentDisplayName;

    @JsonProperty("region")
    private String regionName;

    @JsonProperty("surfaceArea")
    private BigDecimal surfaceArea;

    @JsonProperty("governmentForm")
    private String governmentFormName;

    @JsonProperty("headOfState")
    private String headOfStateName;

    @JsonProperty("independenceYear")
    private Year independenceYear;

    @JsonProperty("population")
    private int populationCount;

    @JsonProperty("lifeExpectancy")
    private Float lifeExpectancy; // See related note in entity decl

    @JsonProperty("GNP")
    private BigDecimal grossNationalProduct;

    @JsonProperty("oldGNP")
    private BigDecimal oldGrossNationalProduct;
}
