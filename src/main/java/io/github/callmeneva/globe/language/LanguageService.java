// SPDX-FileCopyrightText: Copyright 2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.language;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class LanguageService {

    private final LanguageRepository repository;

    @Autowired
    public LanguageService(LanguageRepository repository) {
        this.repository = repository;
    }

    public List<Language> fetchAll(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findAllOfCountry(alpha3Code);
    }

    public List<Language> fetchAll() {
        return repository.findAll();
    }

    public List<Language> fetchAllOfficial(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findAllOfficialOfCountry(alpha3Code);
    }

    public List<Language> fetchAllUnofficial(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findAllUnofficialOfCountry(alpha3Code);
    }

    public Language fetchMostPopular(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findMostPopularOfCountry(alpha3Code).orElseThrow(LanguageNotFoundException::new);
    }

    public Language fetchLeastPopular(String alpha3Code) {
        Assert.notNull(alpha3Code, "Country code is null");
        return repository.findLeastPopularOfCountry(alpha3Code).orElseThrow(LanguageNotFoundException::new);
    }
}
