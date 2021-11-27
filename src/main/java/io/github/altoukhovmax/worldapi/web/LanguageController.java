package io.github.altoukhovmax.worldapi.web;

import io.github.altoukhovmax.worldapi.entity.Language;
import io.github.altoukhovmax.worldapi.repository.LanguageRepository;
import io.github.altoukhovmax.worldapi.web.dto.LanguageDTO;
import io.github.altoukhovmax.worldapi.web.dto.converter.LanguageDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "languages", produces = MediaType.APPLICATION_JSON_VALUE)
public final class LanguageController extends ResourceControllerBase<Language, LanguageDTO> {

    private final LanguageRepository repository;

    @Autowired
    public LanguageController(LanguageRepository repository) {
        super(LanguageDTOConverter.INSTANCE);
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Collection<LanguageDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseOf(alpha3Code == null ?
                repository.findAll() :
                repository.findByAlpha3Code(alpha3Code));
    }
}
