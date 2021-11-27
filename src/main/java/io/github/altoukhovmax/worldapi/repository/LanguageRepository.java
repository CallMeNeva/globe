package io.github.altoukhovmax.worldapi.repository;

import io.github.altoukhovmax.worldapi.model.Language;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Language.PrimaryKey> {

    List<Language> findLanguagesByName(String name);

    List<Language> findLanguagesByCountry_Alpha3Code(String countryAlpha3Code);
}
