/*
 * Copyright 2021 Maxim Altoukhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.altoukhov.world.api.dto;

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
