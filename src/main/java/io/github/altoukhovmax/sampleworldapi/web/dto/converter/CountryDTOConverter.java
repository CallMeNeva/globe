package io.github.altoukhovmax.sampleworldapi.web.dto.converter;

import io.github.altoukhovmax.sampleworldapi.model.Country;
import io.github.altoukhovmax.sampleworldapi.web.dto.CountryDTO;
import org.springframework.core.convert.converter.Converter;

public class CountryDTOConverter implements Converter<Country, CountryDTO> {

    @Override
    public CountryDTO convert(Country country) {
        return new CountryDTO(country);
    }
}
