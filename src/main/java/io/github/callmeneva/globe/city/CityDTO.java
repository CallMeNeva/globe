// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.city;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CityDTO {

    @JsonProperty(value = "name")
    private String name;

    @JsonProperty(value = "country")
    private String countryName;

    @JsonProperty(value = "district")
    private String districtName;

    @JsonProperty(value = "population")
    private int populationCount;
}
