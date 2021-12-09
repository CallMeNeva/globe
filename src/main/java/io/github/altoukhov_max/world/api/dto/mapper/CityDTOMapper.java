package io.github.altoukhov_max.world.api.dto.mapper;

import io.github.altoukhov_max.world.api.dto.CityDTO;
import io.github.altoukhov_max.world.entity.City;

public enum CityDTOMapper implements DTOMapper<City, CityDTO> {
    INSTANCE;

    @Override
    public CityDTO map(City entity) {
        return new CityDTO(entity.getName(),
                           entity.getCountry().getName(),
                           entity.getDistrictName(),
                           entity.getPopulationCount());
    }
}
