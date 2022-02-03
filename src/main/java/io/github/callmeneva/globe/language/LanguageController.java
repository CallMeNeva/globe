// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.language;

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
@RequestMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController {

    private final LanguageService service;
    private final ModelMapper mapper;

    @Autowired
    public LanguageController(LanguageService service, ModelMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<LanguageDTO> allGlobally() {
        List<Language> languages = service.fetchAll();
        return ModelMapperUtils.mapAll(mapper, languages, LanguageDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}")
    public List<LanguageDTO> allOfCountry(@PathVariable String alpha3Code) {
        List<Language> languages = service.fetchAll(alpha3Code);
        return ModelMapperUtils.mapAll(mapper, languages, LanguageDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/official")
    public List<LanguageDTO> allOfficialOfCountry(@PathVariable String alpha3Code) {
        List<Language> languages = service.fetchAllOfficial(alpha3Code);
        return ModelMapperUtils.mapAll(mapper, languages, LanguageDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/unofficial")
    public List<LanguageDTO> allUnofficialOfCountry(@PathVariable String alpha3Code) {
        List<Language> languages = service.fetchAllUnofficial(alpha3Code);
        return ModelMapperUtils.mapAll(mapper, languages, LanguageDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/most-popular")
    public LanguageDTO mostPopularOfCountry(@PathVariable String alpha3Code) {
        Language language = service.fetchMostPopular(alpha3Code);
        return mapper.map(language, LanguageDTO.class);
    }

    @GetMapping(path = "/{alpha3Code}/least-popular")
    public LanguageDTO leastPopularOfCountry(@PathVariable String alpha3Code) {
        Language language = service.fetchLeastPopular(alpha3Code);
        return mapper.map(language, LanguageDTO.class);
    }
}
