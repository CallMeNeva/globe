// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import com.altoukhov.globe.ResponseEntityFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {

    private static final Class<CountryDTO> DTO_CLASS = CountryDTO.class;

    private final CountryRepository repository;
    private final ResponseEntityFactory responseEntityFactory;

    @Autowired
    public CountryController(CountryRepository repository, ResponseEntityFactory responseEntityFactory) {
        this.repository = repository;
        this.responseEntityFactory = responseEntityFactory;
    }

    @GetMapping("{alpha3Code}")
    public ResponseEntity<CountryDTO> ofAlpha3Code(@PathVariable String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findById(alpha3Code), DTO_CLASS);
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> all(@RequestParam(value = "continent", required = false) String continentName) {
        Supplier<List<Country>> countryListSupplier = (continentName != null) ?
                () -> repository.findOfContinent(continentName) :
                repository::findAll;
        return responseEntityFactory.createForList(countryListSupplier, DTO_CLASS);
    }

    @GetMapping("most-populated")
    public ResponseEntity<CountryDTO> mostPopulated(@RequestParam(value = "continent", required = false) String continentName) {
        Supplier<Optional<Country>> countrySupplier = (continentName != null) ?
                () -> repository.findMostPopulatedOfContinent(continentName) :
                repository::findMostPopulated;
        return responseEntityFactory.create(countrySupplier, DTO_CLASS);
    }

    @GetMapping("least-populated")
    public ResponseEntity<CountryDTO> leastPopulated(@RequestParam(value = "continent", required = false) String continentName) {
        Supplier<Optional<Country>> countrySupplier = (continentName != null) ?
                () -> repository.findLeastPopulatedOfContinent(continentName) :
                repository::findLeastPopulated;
        return responseEntityFactory.create(countrySupplier, DTO_CLASS);
    }

    @GetMapping("largest")
    public ResponseEntity<CountryDTO> largest(@RequestParam(value = "continent", required = false) String continentName) {
        Supplier<Optional<Country>> countrySupplier = (continentName != null) ?
                () -> repository.findLargestOfContinent(continentName) :
                repository::findLargest;
        return responseEntityFactory.create(countrySupplier, DTO_CLASS);
    }

    @GetMapping("smallest")
    public ResponseEntity<CountryDTO> smallest(@RequestParam(value = "continent", required = false) String continentName) {
        Supplier<Optional<Country>> countrySupplier = (continentName != null) ?
                () -> repository.findSmallestOfContinent(continentName) :
                repository::findSmallest;
        return responseEntityFactory.create(countrySupplier, DTO_CLASS);
    }
}
