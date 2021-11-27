package io.github.altoukhovmax.worldapi.entity.attribute.converter;

import io.github.altoukhovmax.worldapi.entity.attribute.Continent;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public final class ContinentStringConverter implements AttributeConverter<Continent, String> {

    // Column defined as non-nullable; null-checks are not required

    @Override
    public String convertToDatabaseColumn(Continent attribute) {
        return attribute.displayName();
    }

    @Override
    public Continent convertToEntityAttribute(String dbData) {
        return Continent.byDisplayName(dbData)
                .orElseThrow(() -> new IllegalStateException("Unsupported value: " + dbData));
    }
}
