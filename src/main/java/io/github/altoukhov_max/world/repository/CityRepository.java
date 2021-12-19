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

package io.github.altoukhov_max.world.repository;

import io.github.altoukhov_max.world.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {

    @Query(value = "SELECT * FROM world.city WHERE CountryCode = ?1", nativeQuery = true)
    List<City> findOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.city ORDER BY Population DESC LIMIT 1", nativeQuery = true)
    Optional<City> findMostPopulated();

    @Query(value = "SELECT * FROM world.city WHERE CountryCode = ?1 ORDER BY Population DESC LIMIT 1", nativeQuery = true)
    Optional<City> findMostPopulatedOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.city ORDER BY Population LIMIT 1", nativeQuery = true)
    Optional<City> findLeastPopulated();

    @Query(value = "SELECT * FROM world.city WHERE CountryCode = ?1 ORDER BY Population LIMIT 1", nativeQuery = true)
    Optional<City> findLeastPopulatedOfCountry(String alpha3Code);
}
