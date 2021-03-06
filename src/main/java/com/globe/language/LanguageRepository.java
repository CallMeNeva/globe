package com.globe.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LanguageRepository extends JpaRepository<Language, Language.PrimaryKey> {

    @Query(value = "SELECT * FROM world.countrylanguage WHERE CountryCode = ?1", nativeQuery = true)
    List<Language> findAllOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.countrylanguage WHERE CountryCode = ?1 AND IsOfficial = 'T'", nativeQuery = true)
    List<Language> findAllOfficialOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.countrylanguage WHERE CountryCode = ?1 AND IsOfficial = 'F'", nativeQuery = true)
    List<Language> findAllUnofficialOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.countrylanguage WHERE CountryCode = ?1 ORDER BY Percentage DESC LIMIT 1", nativeQuery = true)
    Optional<Language> findMostPopularOfCountry(String alpha3Code);

    @Query(value = "SELECT * FROM world.countrylanguage WHERE CountryCode = ?1 ORDER BY Percentage LIMIT 1", nativeQuery = true)
    Optional<Language> findLeastPopularOfCountry(String alpha3Code);
}
