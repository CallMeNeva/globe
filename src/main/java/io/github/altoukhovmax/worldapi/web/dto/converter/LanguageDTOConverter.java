package io.github.altoukhovmax.worldapi.web.dto.converter;

import io.github.altoukhovmax.worldapi.entity.Language;
import io.github.altoukhovmax.worldapi.web.dto.LanguageDTO;
import org.springframework.core.convert.converter.Converter;

public class LanguageDTOConverter implements Converter<Language, LanguageDTO> {

    @Override
    public LanguageDTO convert(Language language) {
        return new LanguageDTO(language);
    }
}
