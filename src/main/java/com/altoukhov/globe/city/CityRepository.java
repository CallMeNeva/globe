package com.altoukhov.globe.city;

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
