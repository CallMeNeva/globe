package io.github.altoukhov_max.world.api;

import io.github.altoukhov_max.world.api.dto.CountryDTO;
import io.github.altoukhov_max.world.api.dto.mapper.CountryDTOMapper;
import io.github.altoukhov_max.world.api.util.ResponseEntityFactory;
import io.github.altoukhov_max.world.entity.Country;
import io.github.altoukhov_max.world.repository.CountryRepository;
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
@RequestMapping(value = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController {

    private final CountryRepository repository;
    private final ResponseEntityFactory<Country, CountryDTO> responseEntityFactory;

    @Autowired
    public CountryController(CountryRepository repository) {
        this.repository = repository;
        responseEntityFactory = ResponseEntityFactory.withMapper(CountryDTOMapper.INSTANCE);
    }

    @GetMapping("{alpha3Code}")
    public ResponseEntity<CountryDTO> ofAlpha3Code(@PathVariable String alpha3Code) {
        return responseEntityFactory.create(() -> repository.findById(alpha3Code));
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> all(@RequestParam(value = "continent", required = false) String continentName) {
        return responseEntityFactory.createOfList(continentName != null ?
                () -> repository.findOfContinent(continentName) :
                repository::findAll);
    }

    @GetMapping("most-populated")
    public ResponseEntity<CountryDTO> mostPopulated(@RequestParam(value = "continent", required = false) String continentName) {
        return responseEntityFactory.create(continentName != null ?
                () -> repository.findMostPopulatedOfContinent(continentName) :
                repository::findMostPopulated);
    }

    @GetMapping("least-populated")
    public ResponseEntity<CountryDTO> leastPopulated(@RequestParam(value = "continent", required = false) String continentName) {
        return responseEntityFactory.create(continentName != null ?
                () -> repository.findLeastPopulatedOfContinent(continentName) :
                repository::findLeastPopulated);
    }

    @GetMapping("largest")
    public ResponseEntity<CountryDTO> largest(@RequestParam(value = "continent", required = false) String continentName) {
        return responseEntityFactory.create(continentName != null ?
                () -> repository.findLargestOfContinent(continentName) :
                repository::findLargest);
    }

    @GetMapping("smallest")
    public ResponseEntity<CountryDTO> smallest(@RequestParam(value = "continent", required = false) String continentName) {
        return responseEntityFactory.create(continentName != null ?
                () -> repository.findSmallestOfContinent(continentName) :
                repository::findSmallest);
    }
}
