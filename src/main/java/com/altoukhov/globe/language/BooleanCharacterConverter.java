// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.language;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanCharacterConverter implements AttributeConverter<Boolean, Character> {

    // Column defined as non-nullable: null-checks are not required

    private static final char TRUE_CHAR_VALUE = 'T';
    private static final char FALSE_CHAR_VALUE = 'F';

    @Override
    public Character convertToDatabaseColumn(Boolean attribute) {
        return attribute ? TRUE_CHAR_VALUE : FALSE_CHAR_VALUE;
    }

    @Override
    public Boolean convertToEntityAttribute(Character columnValue) {
        return switch (columnValue) {
            case TRUE_CHAR_VALUE -> Boolean.TRUE;
            case FALSE_CHAR_VALUE -> Boolean.FALSE;
            default -> throw new IllegalArgumentException("Value is not '" + TRUE_CHAR_VALUE + "' or '" + FALSE_CHAR_VALUE + '\'');
        };
    }
}
