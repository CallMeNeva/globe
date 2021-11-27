package io.github.altoukhovmax.worldapi.web.dto.converter;

import io.github.altoukhovmax.worldapi.entity.Language;
import io.github.altoukhovmax.worldapi.web.dto.LanguageDTO;
import org.springframework.core.convert.converter.Converter;

public enum LanguageDTOConverter implements Converter<Language, LanguageDTO> {
    INSTANCE;

    @Override
    public LanguageDTO convert(Language source) {
        return new LanguageDTO(source.getName(),
                               source.getCountry().getName(),
                               source.isOfficial(),
                               source.getPercentage());
    }
}
