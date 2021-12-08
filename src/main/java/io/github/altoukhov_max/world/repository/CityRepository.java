package io.github.altoukhov_max.world.repository;

import io.github.altoukhov_max.world.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Integer> {

    @Query("SELECT c FROM City c WHERE c.country.alpha3Code = ?1")
    List<City> findByAlpha3Code(String alpha3Code);

    @Query("SELECT c FROM City c WHERE c.populationCount = (SELECT MAX(c.populationCount) FROM City c)")
    Optional<City> findMostPopulated();

    @Query("SELECT c FROM City c WHERE c.populationCount = (SELECT MIN(c.populationCount) FROM City c WHERE c.populationCount > 0)")
    Optional<City> findLeastPopulated();
}
