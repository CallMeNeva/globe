package io.github.altoukhov_max.world.api.dto.converter;

import io.github.altoukhov_max.world.entity.City;
import io.github.altoukhov_max.world.api.dto.CityDTO;
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
