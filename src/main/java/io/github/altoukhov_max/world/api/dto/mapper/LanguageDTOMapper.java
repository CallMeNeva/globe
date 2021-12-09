package io.github.altoukhov_max.world.api.dto.mapper;

import io.github.altoukhov_max.world.api.dto.LanguageDTO;
import io.github.altoukhov_max.world.entity.Language;

public enum LanguageDTOMapper implements DTOMapper<Language, LanguageDTO> {
    INSTANCE;

    @Override
    public LanguageDTO map(Language entity) {
        return new LanguageDTO(entity.getName(),
                               entity.getCountry().getName(),
                               entity.isOfficial(),
                               entity.getPercentage());
    }
}
