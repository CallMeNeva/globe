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

import com.altoukhov.world.entity.attribute.Continent;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContinentStringConverter implements AttributeConverter<Continent, String> {

    // Column defined as non-nullable; null-checks are not required

    @Override
    public String convertToDatabaseColumn(Continent attribute) {
        return attribute.getDisplayName();
    }

    @Override
    public Continent convertToEntityAttribute(String dbData) {
        return Continent.of(dbData).orElseThrow(() -> new IllegalStateException("Unsupported value: " + dbData));
    }
}