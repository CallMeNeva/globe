package com.altoukhov.globe.api;

import com.altoukhov.globe.api.dto.LanguageDTO;
import com.altoukhov.globe.api.util.ResponseEntityFactory;
import com.altoukhov.globe.entity.Language;
import com.altoukhov.globe.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Supplier;

@RestController
@RequestMapping(value = "languages", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController {

    private static final Class<LanguageDTO> DTO_CLASS = LanguageDTO.class;

    private final LanguageRepository repository;
    private final ResponseEntityFactory responseEntityFactory;

    @Autowired
    public LanguageController(LanguageRepository repository, ResponseEntityFactory responseEntityFactory) {
        this.repository = repository;
        this.responseEntityFactory = responseEntityFactory;
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        Supplier<List<Language>> languageListSupplier = (alpha3Code != null) ?
                () -> repository.findOfCountry(alpha3Code) :
                repository::findAll;
        return responseEntityFactory.createForList(languageListSupplier, DTO_CLASS);
    }

    @GetMapping("official")
    public ResponseEntity<List<LanguageDTO>> official(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createForList(() -> repository.findOfficialOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("unofficial")
    public ResponseEntity<List<LanguageDTO>> unofficial(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createForList(() -> repository.findUnofficialOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("most-popular")
    public ResponseEntity<LanguageDTO> mostPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findMostPopularOfCountry(alpha3Code), DTO_CLASS);
    }

    @GetMapping("least-popular")
    public ResponseEntity<LanguageDTO> leastPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findLeastPopularOfCountry(alpha3Code), DTO_CLASS);
    }
}
