package io.github.altoukhovmax.sampleworldapi.repository;

import io.github.altoukhovmax.sampleworldapi.model.Continent;
import io.github.altoukhovmax.sampleworldapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, String> {

    List<Country> findCountriesByContinent(Continent continent);
}
