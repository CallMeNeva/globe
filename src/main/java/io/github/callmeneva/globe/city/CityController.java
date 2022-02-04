// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.city;

import io.github.callmeneva.globe.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityService service;
    private final ModelMapper mapper;

    @Autowired
    public CityController(CityService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CityDTO> allGlobally() {
        List<City> cities = service.fetchAll();
        return ModelMapperUtils.mapAll(mapper, cities, CityDTO.class);
    }

    @GetMapping(path = "/most-populated")
    public CityDTO mostPopulatedGlobally() {
        City city = service.fetchMostPopulated();
        return mapper.map(city, CityDTO.class);
    }

    @GetMapping(path = "/least-populated")
    public CityDTO leastPopulatedGlobally() {
        City city = service.fetchLeastPopulated();
        return mapper.map(city, CityDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}")
    public List<CityDTO> allOfCountry(@PathVariable String alpha3Code) {
        List<City> cities = service.fetchAll(alpha3Code);
        return ModelMapperUtils.mapAll(mapper, cities, CityDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/most-populated")
    public CityDTO mostPopulatedOfCountry(@PathVariable String alpha3Code) {
        City city = service.fetchMostPopulated(alpha3Code);
        return mapper.map(city, CityDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/least-populated")
    public CityDTO leastPopulatedOfCountry(@PathVariable String alpha3Code) {
        City city = service.fetchLeastPopulated(alpha3Code);
        return mapper.map(city, CityDTO.class);
    }
}
