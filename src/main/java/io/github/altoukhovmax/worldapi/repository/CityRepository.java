package io.github.altoukhovmax.worldapi.repository;

import io.github.altoukhovmax.worldapi.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Integer> {

    List<City> findCitiesByCountry_Alpha3Code(String countryAlpha3Code);
}
