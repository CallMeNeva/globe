package io.github.altoukhov_max.world.api;

import io.github.altoukhov_max.world.entity.City;
import io.github.altoukhov_max.world.repository.CityRepository;
import io.github.altoukhov_max.world.api.dto.CityDTO;
import io.github.altoukhov_max.world.api.dto.converter.CityDTOConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping(value = "cities", produces = MediaType.APPLICATION_JSON_VALUE)
public final class CityController extends ResourceControllerBase<City, CityDTO> {

    private final CityRepository repository;

    @Autowired
    public CityController(CityRepository repository) {
        super(CityDTOConverter.INSTANCE);
        this.repository = repository;
    }

    @GetMapping
    public ResponseEntity<Collection<CityDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseOf(alpha3Code == null ?
                repository.findAll() :
                repository.findByAlpha3Code(alpha3Code));
    }

    @GetMapping("{id}")
    public ResponseEntity<CityDTO> byId(@PathVariable int id) {
        return responseOf(repository.findById(id));
    }

    @GetMapping("most-populated")
    public ResponseEntity<CityDTO> mostPopulated() {
        return responseOf(repository.findMostPopulated());
    }

    @GetMapping("least-populated")
    public ResponseEntity<CityDTO> leastPopulated() {
        return responseOf(repository.findLeastPopulated());
    }
}
