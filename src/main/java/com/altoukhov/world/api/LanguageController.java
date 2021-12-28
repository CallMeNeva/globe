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

package com.altoukhov.world.api;

import com.altoukhov.world.api.dto.LanguageDTO;
import com.altoukhov.world.api.util.ResponseEntityFactory;
import com.altoukhov.world.entity.Language;
import com.altoukhov.world.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "languages", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController {

    private static final Class<LanguageDTO> DTO_CLASS = LanguageDTO.class;

    private final LanguageRepository repository;
    private final ResponseEntityFactory responseEntityFactory;

    @Autowired
    public LanguageController(LanguageRepository repository, ResponseEntityFactory responseEntityFactory) {
        this.repository = repository;
        this.responseEntityFactory = responseEntityFactory;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        Supplier<List<Language>> languageListSupplier = (alpha3Code != null) ?
                () -> repository.findOfCountry(alpha3Code) :
                repository::findAll;
        return responseEntityFactory.createForList(languageListSupplier, DTO_CLASS);
    }

    @GetMapping("official")
    public ResponseEntity<List<LanguageDTO>> official(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createForList(() -> repository.findOfficialOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("unofficial")
    public ResponseEntity<List<LanguageDTO>> unofficial(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createForList(() -> repository.findUnofficialOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("most-popular")
    public ResponseEntity<LanguageDTO> mostPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findMostPopularOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("least-popular")
    public ResponseEntity<LanguageDTO> leastPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findLeastPopularOfCountry(alpha3Code), DTO_CLASS);
    }
}