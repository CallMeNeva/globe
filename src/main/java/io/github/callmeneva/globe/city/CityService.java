// SPDX-FileCopyrightText: Copyright 2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CityService {

    private final CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public List<City> fetchAll(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findAllOfCountry(alpha3Code);
    }

    public List<City> fetchAll() {
        return repository.findAll();
    }

    public City fetchMostPopulated(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findMostPopulatedOfCountry(alpha3Code).orElseThrow(CityNotFoundException::new);
    }

    public City fetchMostPopulated() {
        return repository.findMostPopulated().orElseThrow(CityNotFoundException::new);
    }

    public City fetchLeastPopulated(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findLeastPopulatedOfCountry(alpha3Code).orElseThrow(CityNotFoundException::new);
    }

    public City fetchLeastPopulated() {
        return repository.findLeastPopulated().orElseThrow(CityNotFoundException::new);
    }
}
