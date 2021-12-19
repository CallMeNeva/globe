/*
 * Copyright 2021 Maxim Altoukhov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

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
