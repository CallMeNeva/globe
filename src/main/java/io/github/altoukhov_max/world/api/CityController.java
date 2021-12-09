package io.github.altoukhov_max.world.api;

import io.github.altoukhov_max.world.api.dto.CityDTO;
import io.github.altoukhov_max.world.api.dto.mapper.CityDTOMapper;
import io.github.altoukhov_max.world.api.util.ResponseEntityFactory;
import io.github.altoukhov_max.world.entity.City;
import io.github.altoukhov_max.world.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController {

    private final CityRepository repository;
    private final ResponseEntityFactory<City, CityDTO> responseEntityFactory;

    @Autowired
    public CityController(CityRepository repository) {
        this.repository = repository;
        this.responseEntityFactory = ResponseEntityFactory.withMapper(CityDTOMapper.INSTANCE);
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> all(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseEntityFactory.createOfList(alpha3Code != null ?
                () -> repository.findOfCountry(alpha3Code) :
                repository::findAll);
    }

    @GetMapping("most-populated")
    public ResponseEntity<CityDTO> mostPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseEntityFactory.create(alpha3Code != null ?
                () -> repository.findMostPopulatedOfCountry(alpha3Code) :
                repository::findMostPopulated);
    }

    @GetMapping("least-populated")
    public ResponseEntity<CityDTO> leastPopulated(@RequestParam(value = "country", required = false) String alpha3Code) {
        return responseEntityFactory.create(alpha3Code != null ?
                () -> repository.findLeastPopulatedOfCountry(alpha3Code) :
                repository::findLeastPopulated);
    }
}
