package io.github.altoukhov_max.world.repository;

import io.github.altoukhov_max.world.entity.Country;
import io.github.altoukhov_max.world.entity.attribute.Continent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CountryRepository extends JpaRepository<Country, String> {

    @Query("SELECT c FROM Country c WHERE c.continent = ?1")
    List<Country> findByContinent(Continent continent);

    @Query("SELECT c FROM Country c WHERE c.populationCount = (SELECT MAX(c.populationCount) FROM Country c)")
    Optional<Country> findMostPopulated();

    @Query("SELECT c FROM Country c WHERE c.populationCount = (SELECT MIN(c.populationCount) FROM Country c WHERE c.populationCount > 0)")
    Optional<Country> findLeastPopulated();

    @Query("SELECT c FROM Country c WHERE c.surfaceArea = (SELECT MAX(c.surfaceArea) FROM Country c)")
    Optional<Country> findLargest();

    @Query("SELECT c FROM Country c WHERE c.surfaceArea = (SELECT MIN(c.surfaceArea) FROM Country c)")
    Optional<Country> findSmallest();
}
