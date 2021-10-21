package io.github.altoukhovmax.sampleworldapi.web;

import io.github.altoukhovmax.sampleworldapi.model.Country;
import io.github.altoukhovmax.sampleworldapi.repository.CountryRepository;
import io.github.altoukhovmax.sampleworldapi.web.dto.CountryDTO;
import io.github.altoukhovmax.sampleworldapi.web.dto.converter.CountryDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
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
    public ResponseEntity<List<CountryDTO>> showAll() {
        return showList(repository.findAll());
    }
}
