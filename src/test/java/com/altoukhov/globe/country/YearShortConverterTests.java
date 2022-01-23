// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import com.altoukhov.globe.country.YearShortConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;

public final class YearShortConverterTests {

    private static final YearShortConverter CONVERTER = new YearShortConverter();

    @Test
    public void convertsAttributeValue() {
        Year attributeValue = Year.of(1984);
        Assertions.assertEquals((short) 1984, CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsColumnValue() {
        short columnValue = 1984;
        Assertions.assertEquals(Year.of(1984), CONVERTER.convertToEntityAttribute(columnValue));
    }
}
