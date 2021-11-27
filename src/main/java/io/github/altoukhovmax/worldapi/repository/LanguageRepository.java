package io.github.altoukhovmax.worldapi.repository;

import io.github.altoukhovmax.worldapi.entity.Language;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LanguageRepository extends JpaRepository<Language, Language.PrimaryKey> {

    @Query("select l from Language l where l.country.alpha3Code = ?1")
    List<Language> findByAlpha3Code(String countryAlpha3Code);
}
