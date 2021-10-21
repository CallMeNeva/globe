package io.github.altoukhovmax.sampleworldapi.web.dto.converter;

import io.github.altoukhovmax.sampleworldapi.model.Language;
import io.github.altoukhovmax.sampleworldapi.web.dto.LanguageDTO;
import org.springframework.core.convert.converter.Converter;

public class LanguageDTOConverter implements Converter<Language, LanguageDTO> {

    @Override
    public LanguageDTO convert(Language language) {
        return new LanguageDTO(language);
    }
}
