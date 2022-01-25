// SPDX-FileCopyrightText: Copyright 2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CountryService {

    private final CountryRepository repository;

    @Autowired
    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public List<Country> fetchAll(String continentName) {
        Assert.notNull(continentName, "Continent name is null");
        return repository.findAllOfContinent(continentName);
    }

    public List<Country> fetchAll() {
        return repository.findAll();
    }

    public Country fetchMostPopulated(String continentName) {
        Assert.notNull(continentName, "Continent name is null");
        return repository.findMostPopulatedOfContinent(continentName).orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchMostPopulated() {
        return repository.findMostPopulated().orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchLeastPopulated(String continentName) {
        Assert.notNull(continentName, "Continent name is null");
        return repository.findLeastPopulatedOfContinent(continentName).orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchLeastPopulated() {
        return repository.findLeastPopulated().orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchLargest(String continentName) {
        Assert.notNull(continentName, "Continent name is null");
        return repository.findLargestOfContinent(continentName).orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchLargest() {
        return repository.findLargest().orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchSmallest(String continentName) {
        Assert.notNull(continentName, "Continent name is null");
        return repository.findSmallestOfContinent(continentName).orElseThrow(CountryNotFoundException::new);
    }

    public Country fetchSmallest() {
        return repository.findSmallest().orElseThrow(CountryNotFoundException::new);
    }
}
