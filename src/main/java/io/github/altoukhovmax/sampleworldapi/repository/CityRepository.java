package io.github.altoukhovmax.sampleworldapi.repository;

import io.github.altoukhovmax.sampleworldapi.model.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Integer> {
}
