// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.city;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityService service;
    private final ModelMapper mapper;

    @Autowired
    public CityController(CityService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CityDTO> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        List<City> cities = (alpha3Code == null) ? service.fetchAll() : service.fetchAll(alpha3Code);
        return cities.stream()
                .map(city -> mapper.map(city, CityDTO.class))
                .toList();
    }

    @GetMapping("most-populated")
    public CityDTO mostPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        City city = (alpha3Code == null) ? service.fetchMostPopulated() : service.fetchMostPopulated(alpha3Code);
        return mapper.map(city, CityDTO.class);
    }

    @GetMapping("least-populated")
    public CityDTO leastPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        City city = (alpha3Code == null) ? service.fetchLeastPopulated() : service.fetchLeastPopulated(alpha3Code);
        return mapper.map(city, CityDTO.class);
    }
}
