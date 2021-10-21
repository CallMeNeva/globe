package io.github.altoukhovmax.sampleworldapi.web;

import io.github.altoukhovmax.sampleworldapi.model.Language;
import io.github.altoukhovmax.sampleworldapi.repository.LanguageRepository;
import io.github.altoukhovmax.sampleworldapi.web.dto.LanguageDTO;
import io.github.altoukhovmax.sampleworldapi.web.dto.converter.LanguageDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/languages", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController extends ResourceControllerBase<Language, LanguageDTO> {

    private final LanguageRepository repository;

    @Autowired
    public LanguageController(LanguageRepository repository) {
        super(new LanguageDTOConverter());
        this.repository = repository;
    }

    @GetMapping("/{name}")
    public ResponseEntity<List<LanguageDTO>> showByName(@PathVariable String name) {
        return showList(repository.findLanguagesByName(name));
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> showAll(@RequestParam(value = "country", required = false) String countryAlpha3Code) {
        List<Language> languages = countryAlpha3Code == null ?
                repository.findAll() :
                repository.findLanguagesByCountry_Alpha3Code(countryAlpha3Code);
        return showList(languages);
    }
}
