// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

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
