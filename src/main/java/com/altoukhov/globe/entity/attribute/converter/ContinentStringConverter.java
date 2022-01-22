package com.altoukhov.globe.entity.attribute.converter;

import com.altoukhov.globe.entity.attribute.Continent;

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
