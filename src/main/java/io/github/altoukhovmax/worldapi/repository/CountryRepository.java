package io.github.altoukhovmax.worldapi.repository;

import io.github.altoukhovmax.worldapi.entity.attribute.Continent;
import io.github.altoukhovmax.worldapi.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findCountriesByContinent(Continent continent);
}
