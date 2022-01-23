// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.language;

import com.altoukhov.globe.language.BooleanCharacterConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BooleanCharacterConverterTests {

    private static final BooleanCharacterConverter CONVERTER = new BooleanCharacterConverter();

    @Test
    public void convertsAttributeValue() {
        boolean attributeValue = true;
        Assertions.assertEquals('T', CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsValidColumnValue() {
        char columnValue = 'F';
        Assertions.assertEquals(false, CONVERTER.convertToEntityAttribute(columnValue));
    }

    @Test
    public void throwsOnInvalidColumnValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CONVERTER.convertToEntityAttribute('Z'));
    }
}
