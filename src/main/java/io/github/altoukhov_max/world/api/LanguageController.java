package io.github.altoukhov_max.world.api;

import io.github.altoukhov_max.world.api.dto.LanguageDTO;
import io.github.altoukhov_max.world.api.dto.mapper.LanguageDTOMapper;
import io.github.altoukhov_max.world.api.util.ResponseEntityFactory;
import io.github.altoukhov_max.world.entity.Language;
import io.github.altoukhov_max.world.repository.LanguageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "languages", produces = MediaType.APPLICATION_JSON_VALUE)
public class LanguageController {

    private final LanguageRepository repository;
    private final ResponseEntityFactory<Language, LanguageDTO> responseEntityFactory;

    @Autowired
    public LanguageController(LanguageRepository repository) {
        this.repository = repository;
        this.responseEntityFactory = ResponseEntityFactory.withMapper(LanguageDTOMapper.INSTANCE);
    }

    @GetMapping
    public ResponseEntity<List<LanguageDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseEntityFactory.createOfList(alpha3Code != null ?
                () -> repository.findOfCountry(alpha3Code) :
                repository::findAll);
    }

    @GetMapping("official")
    public ResponseEntity<List<LanguageDTO>> official(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createOfList(() -> repository.findOfficialOfCountry(alpha3Code));
    }

    @GetMapping("unofficial")
    public ResponseEntity<List<LanguageDTO>> unofficial(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.createOfList(() -> repository.findUnofficialOfCountry(alpha3Code));
    }

    @GetMapping("most-popular")
    public ResponseEntity<LanguageDTO> mostPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findMostPopularOfCountry(alpha3Code));
    }

    @GetMapping("least-popular")
    public ResponseEntity<LanguageDTO> leastPopular(@RequestParam("country") String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findLeastPopularOfCountry(alpha3Code));
    }
}
