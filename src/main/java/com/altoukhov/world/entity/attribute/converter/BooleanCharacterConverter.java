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

package com.altoukhov.world.entity.attribute.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanCharacterConverter implements AttributeConverter<Boolean, Character> {

    // Column defined as non-nullable; null-checks are not required

    private static final char TRUE_CHAR_VALUE = 'T';
    private static final char FALSE_CHAR_VALUE = 'F';

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        return attribute ? TRUE_CHAR_VALUE : FALSE_CHAR_VALUE;
    }

    @Override
    public Boolean convertToEntityAttribute(Character dbData) {
        return switch (dbData) {
            case TRUE_CHAR_VALUE -> Boolean.TRUE;
            case FALSE_CHAR_VALUE -> Boolean.FALSE;
            default -> throw new IllegalArgumentException("Value is not '" + TRUE_CHAR_VALUE + "' or '" + FALSE_CHAR_VALUE + '\'');
        };
    }
}
