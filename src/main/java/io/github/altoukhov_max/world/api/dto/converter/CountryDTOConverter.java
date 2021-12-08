package io.github.altoukhov_max.world.api.dto.converter;

import io.github.altoukhov_max.world.entity.Country;
import io.github.altoukhov_max.world.api.dto.CountryDTO;
import org.springframework.core.convert.converter.Converter;

public enum CountryDTOConverter implements Converter<Country, CountryDTO> {
    INSTANCE;

    @Override
    public CountryDTO convert(Country source) {
        return new CountryDTO(source.getName(),
                              source.getLocalName(),
                              source.getAlpha2Code(),
                              source.getCapital() == null ? null : source.getCapital().getName(),
                              source.getContinent().displayName(),
                              source.getRegionName(),
                              source.getSurfaceArea(),
                              source.getGovernmentFormName(),
                              source.getHeadOfStateName(),
                              source.getIndependenceYear(),
                              source.getPopulationCount(),
                              source.getLifeExpectancy(),
                              source.getGrossNationalProduct(),
                              source.getOldGrossNationalProduct());
    }
}
