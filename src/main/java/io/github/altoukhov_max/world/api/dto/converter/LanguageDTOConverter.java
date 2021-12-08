package io.github.altoukhov_max.world.api.dto.converter;

import io.github.altoukhov_max.world.entity.Language;
import io.github.altoukhov_max.world.api.dto.LanguageDTO;
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
