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

import com.altoukhov.world.api.dto.CityDTO;
import com.altoukhov.world.api.util.ResponseEntityFactory;
import com.altoukhov.world.entity.City;
import com.altoukhov.world.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private static final Class<CityDTO> DTO_CLASS = CityDTO.class;

    private final CityRepository repository;
    private final ResponseEntityFactory responseEntityFactory;

    @Autowired
    public CityController(CityRepository repository, ResponseEntityFactory responseEntityFactory) {
        this.repository = repository;
        this.responseEntityFactory = responseEntityFactory;
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        Supplier<List<City>> cityListSupplier = (alpha3Code != null) ?
                () -> repository.findOfCountry(alpha3Code) :
                repository::findAll;
        return responseEntityFactory.createForList(cityListSupplier, DTO_CLASS);
    }

    @GetMapping("most-populated")
    public ResponseEntity<CityDTO> mostPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        Supplier<Optional<City>> citySupplier = (alpha3Code != null) ?
                () -> repository.findMostPopulatedOfCountry(alpha3Code) :
                repository::findMostPopulated;
        return responseEntityFactory.create(citySupplier, DTO_CLASS);
    }

    @GetMapping("least-populated")
    public ResponseEntity<CityDTO> leastPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        Supplier<Optional<City>> citySupplier = (alpha3Code != null) ?
                () -> repository.findLeastPopulatedOfCountry(alpha3Code) :
                repository::findLeastPopulated;
        return responseEntityFactory.create(citySupplier, DTO_CLASS);
    }
}