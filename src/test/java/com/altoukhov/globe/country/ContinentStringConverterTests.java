// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import com.altoukhov.globe.country.Continent;
import com.altoukhov.globe.country.ContinentStringConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinentStringConverterTests {

    private static final ContinentStringConverter CONVERTER = new ContinentStringConverter();

    @Test
    public void convertsAttributeValue() {
        Continent attributeValue = Continent.EUROPE;
        Assertions.assertEquals("Europe", CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsValidColumnValue() {
        String columnValue = "Europe";
        Assertions.assertEquals(Continent.EUROPE, CONVERTER.convertToEntityAttribute(columnValue));
    }

    @Test
    public void throwsOnInvalidColumnValue() {
        Assertions.assertThrows(IllegalStateException.class, () -> CONVERTER.convertToEntityAttribute("Kalimdor"));
    }
}
