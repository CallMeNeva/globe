package io.github.altoukhovmax.worldapi.web;

import io.github.altoukhovmax.worldapi.model.City;
import io.github.altoukhovmax.worldapi.repository.CityRepository;
import io.github.altoukhovmax.worldapi.web.dto.CityDTO;
import io.github.altoukhovmax.worldapi.web.dto.converter.CityDTOConverter;
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
@RequestMapping(value = "/cities", produces = MediaType.APPLICATION_JSON_VALUE)
public class CityController extends ResourceControllerBase<City, CityDTO> {

    private final CityRepository repository;

    @Autowired
    public CityController(CityRepository repository) {
        super(new CityDTOConverter());
        this.repository = repository;
    }

    @GetMapping("/{identifier}")
    public ResponseEntity<CityDTO> showByIdentifier(@PathVariable int identifier) {
        return showOne(repository.findById(identifier));
    }

    @GetMapping
    public ResponseEntity<List<CityDTO>> showAll(@RequestParam(value = "country", required = false) String countryAlpha3Code) {
        List<City> cities = countryAlpha3Code == null ?
                repository.findAll() :
                repository.findCitiesByCountry_Alpha3Code(countryAlpha3Code);
        return showList(cities);
    }
}
