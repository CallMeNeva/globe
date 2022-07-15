package com.globe.country;

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

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "localName")
    private String localName;

    @JsonProperty(value = "alpha2")
    private String alpha2Code;

    @JsonProperty(value = "capital")
    private String capitalName;

    @JsonProperty(value = "continent")
    private String continentDisplayName;

    @JsonProperty(value = "region")
    private String regionName;

    @JsonProperty(value = "surfaceArea")
    private BigDecimal surfaceArea;

    @JsonProperty(value = "governmentForm")
    private String governmentFormName;

    @JsonProperty(value = "headOfState")
    private String headOfStateName;

    @JsonProperty(value = "independenceYear")
    private Year independenceYear;

    @JsonProperty(value = "population")
    private int populationCount;

    @JsonProperty(value = "lifeExpectancy")
    private Float lifeExpectancy; // See related note in entity declaration

    @JsonProperty(value = "GNP")
    private BigDecimal grossNationalProduct;

    @JsonProperty(value = "oldGNP")
    private BigDecimal oldGrossNationalProduct;
}
