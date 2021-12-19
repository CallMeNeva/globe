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

import io.github.altoukhov_max.world.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {

    @Query(value = "SELECT * FROM world.country WHERE Continent = ?1", nativeQuery = true)
    List<Country> findOfContinent(String continentName);

    @Query(value = "SELECT * FROM world.country ORDER BY Population DESC LIMIT 1", nativeQuery = true)
    Optional<Country> findMostPopulated();

    @Query(value = "SELECT * FROM world.country WHERE Continent = ?1 ORDER BY Population DESC LIMIT 1", nativeQuery = true)
    Optional<Country> findMostPopulatedOfContinent(String continentName);

    @Query(value = "SELECT * FROM world.country ORDER BY Population LIMIT 1", nativeQuery = true)
    Optional<Country> findLeastPopulated();

    @Query(value = "SELECT * FROM world.country WHERE Continent = ?1 ORDER BY Population LIMIT 1", nativeQuery = true)
    Optional<Country> findLeastPopulatedOfContinent(String continentName);

    @Query(value = "SELECT * FROM world.country ORDER BY SurfaceArea DESC LIMIT 1", nativeQuery = true)
    Optional<Country> findLargest();

    @Query(value = "SELECT * FROM world.country WHERE Continent = ?1 ORDER BY SurfaceArea DESC LIMIT 1", nativeQuery = true)
    Optional<Country> findLargestOfContinent(String continentName);

    @Query(value = "SELECT * FROM world.country ORDER BY SurfaceArea LIMIT 1", nativeQuery = true)
    Optional<Country> findSmallest();

    @Query(value = "SELECT * FROM world.country WHERE Continent = ?1 ORDER BY SurfaceArea LIMIT 1", nativeQuery = true)
    Optional<Country> findSmallestOfContinent(String continentName);
}
