package io.github.altoukhovmax.worldapi.repository;

import io.github.altoukhovmax.worldapi.model.Continent;
import io.github.altoukhovmax.worldapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findCountriesByContinent(Continent continent);
}
