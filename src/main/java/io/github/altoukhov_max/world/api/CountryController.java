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

package io.github.altoukhov_max.world.api;

import io.github.altoukhov_max.world.api.dto.CountryDTO;
import io.github.altoukhov_max.world.api.util.ResponseEntityFactory;
import io.github.altoukhov_max.world.entity.Country;
import io.github.altoukhov_max.world.repository.CountryRepository;
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
