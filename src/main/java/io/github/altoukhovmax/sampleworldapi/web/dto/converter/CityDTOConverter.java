package io.github.altoukhovmax.sampleworldapi.web.dto.converter;

import io.github.altoukhovmax.sampleworldapi.model.City;
import io.github.altoukhovmax.sampleworldapi.web.dto.CityDTO;
import org.springframework.core.convert.converter.Converter;

public class CityDTOConverter implements Converter<City, CityDTO> {

    @Override
    public CityDTO convert(City city) {
        return new CityDTO(city);
    }
}
