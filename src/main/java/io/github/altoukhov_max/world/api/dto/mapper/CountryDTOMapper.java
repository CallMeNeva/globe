package io.github.altoukhov_max.world.api.dto.mapper;

import io.github.altoukhov_max.world.api.dto.CountryDTO;
import io.github.altoukhov_max.world.entity.Country;

public enum CountryDTOMapper implements DTOMapper<Country, CountryDTO> {
    INSTANCE;

    @Override
    public CountryDTO map(Country entity) {
        return new CountryDTO(entity.getName(),
                              entity.getLocalName(),
                              entity.getAlpha2Code(),
                              entity.getCapital() == null ? null : entity.getCapital().getName(),
                              entity.getContinent().displayName(),
                              entity.getRegionName(),
                              entity.getSurfaceArea(),
                              entity.getGovernmentFormName(),
                              entity.getHeadOfStateName(),
                              entity.getIndependenceYear(),
                              entity.getPopulationCount(),
                              entity.getLifeExpectancy(),
                              entity.getGrossNationalProduct(),
                              entity.getOldGrossNationalProduct());
    }
}
