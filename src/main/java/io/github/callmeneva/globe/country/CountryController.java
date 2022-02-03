// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.country;

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
@RequestMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryService service;
    private final ModelMapper mapper;

    @Autowired
    public CountryController(CountryService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<CountryDTO> allGlobally() {
        List<Country> countries = service.fetchAll();
        return ModelMapperUtils.mapAll(mapper, countries, CountryDTO.class);
    }

    @GetMapping(path = "/most-populated")
    public CountryDTO mostPopulatedGlobally() {
        Country country = service.fetchMostPopulated();
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/least-populated")
    public CountryDTO leastPopulatedGlobally() {
        Country country = service.fetchLeastPopulated();
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/largest")
    public CountryDTO largestGlobally() {
        Country country = service.fetchLargest();
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/smallest")
    public CountryDTO smallestGlobally() {
        Country country = service.fetchSmallest();
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/{continentName}")
    public List<CountryDTO> allOfContinent(@PathVariable String continentName) {
        List<Country> countries = service.fetchAll(continentName);
        return ModelMapperUtils.mapAll(mapper, countries, CountryDTO.class);
    }

    @GetMapping(path = "/{continentName}/most-populated")
    public CountryDTO mostPopulatedOfContinent(@PathVariable String continentName) {
        Country country = service.fetchMostPopulated(continentName);
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/{continentName}/least-populated")
    public CountryDTO leastPopulatedOfContinent(@PathVariable String continentName) {
        Country country = service.fetchLeastPopulated(continentName);
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/{continentName}/largest")
    public CountryDTO largestOfContinent(@PathVariable String continentName) {
        Country country = service.fetchLargest(continentName);
        return mapper.map(country, CountryDTO.class);
    }

    @GetMapping(path = "/{continentName}/smallest")
    public CountryDTO smallestOfContinent(@PathVariable String continentName) {
        Country country = service.fetchSmallest(continentName);
        return mapper.map(country, CountryDTO.class);
    }
}
