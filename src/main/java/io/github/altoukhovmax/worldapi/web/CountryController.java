package io.github.altoukhovmax.worldapi.web;

import io.github.altoukhovmax.worldapi.entity.Country;
import io.github.altoukhovmax.worldapi.entity.attribute.Continent;
import io.github.altoukhovmax.worldapi.repository.CountryRepository;
import io.github.altoukhovmax.worldapi.web.dto.CountryDTO;
import io.github.altoukhovmax.worldapi.web.dto.converter.CountryDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping(value = "countries", produces = MediaType.APPLICATION_JSON_VALUE)
public final class CountryController extends ResourceControllerBase<Country, CountryDTO> {

    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        super(CountryDTOConverter.INSTANCE);
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Collection<CountryDTO>> all(@RequestParam(value = "continent", required = false) String continentName) {
        if (continentName == null) {
            return responseOf(repository.findAll());
        }
        Optional<Continent> continent = Continent.byDisplayName(continentName);
        return continent.map(c -> responseOf(repository.findByContinent(c)))
                .orElse(new ResponseEntity<>(HttpStatus.BAD_REQUEST));
    }

    @GetMapping("{alpha3Code}")
    public ResponseEntity<CountryDTO> byAlpha3Code(@PathVariable String alpha3Code) {
        return responseOf(repository.findById(alpha3Code));
    }

    @GetMapping("most-populated")
    public ResponseEntity<CountryDTO> mostPopulated() {
        return responseOf(repository.findMostPopulated());
    }

    @GetMapping("least-populated")
    public ResponseEntity<CountryDTO> leastPopulated() {
        return responseOf(repository.findLeastPopulated());
    }

    @GetMapping("largest")
    public ResponseEntity<CountryDTO> largest() {
        return responseOf(repository.findLargest());
    }

    @GetMapping("smallest")
    public ResponseEntity<CountryDTO> smallest() {
        return responseOf(repository.findSmallest());
    }
}
