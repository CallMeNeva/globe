package io.github.altoukhovmax.worldapi.web.dto.converter;

import io.github.altoukhovmax.worldapi.entity.City;
import io.github.altoukhovmax.worldapi.web.dto.CityDTO;
import org.springframework.core.convert.converter.Converter;

public enum CityDTOConverter implements Converter<City, CityDTO> {
    INSTANCE;

    @Override
    public CityDTO convert(City source) {
        return new CityDTO(source.getName(),
                           source.getCountry().getName(),
                           source.getDistrictName(),
                           source.getPopulationCount());
    }
}
