package io.github.altoukhovmax.sampleworldapi.repository;

import io.github.altoukhovmax.sampleworldapi.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, String> {
}
