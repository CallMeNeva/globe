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

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Year;

public final class YearShortConverterTests {

    private static final YearShortConverter CONVERTER = new YearShortConverter();

    @Test
    public void convertsAttribute() {
        Year attributeValue = Year.of(1984);
        Assertions.assertEquals((short) 1984, CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsColumnValue() {
        short columnValue = 1984;
        Assertions.assertEquals(Year.of(1984), CONVERTER.convertToEntityAttribute(columnValue));
    }
}
