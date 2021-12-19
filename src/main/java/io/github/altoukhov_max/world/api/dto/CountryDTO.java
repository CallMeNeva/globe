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

package io.github.altoukhov_max.world.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

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
}
