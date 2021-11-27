package io.github.altoukhovmax.worldapi.web;

import io.github.altoukhovmax.worldapi.entity.attribute.Continent;
import io.github.altoukhovmax.worldapi.entity.Country;
import io.github.altoukhovmax.worldapi.repository.CountryRepository;
import io.github.altoukhovmax.worldapi.web.dto.CountryDTO;
import io.github.altoukhovmax.worldapi.web.dto.converter.CountryDTOConverter;
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
@RequestMapping(value = "/countries", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryController extends ResourceControllerBase<Country, CountryDTO> {

    private final CountryRepository repository;

    @Autowired
    public CountryController(CountryRepository repository) {
        super(new CountryDTOConverter());
        this.repository = repository;
    }

    @GetMapping("/{alpha3Code}")
    public ResponseEntity<CountryDTO> showByAlpha3Code(@PathVariable String alpha3Code) {
        return showOne(repository.findById(alpha3Code));
    }

    @GetMapping
    public ResponseEntity<List<CountryDTO>> showAll(@RequestParam(value = "continent", required = false) String continentName) {
        List<Country> countries = continentName == null ?
                repository.findAll() :
                repository.findCountriesByContinent(Continent.fromDisplayName(continentName));
        return showList(countries);
    }
}
