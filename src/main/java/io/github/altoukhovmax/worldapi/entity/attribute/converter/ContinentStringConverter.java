package io.github.altoukhovmax.worldapi.entity.attribute.converter;

import io.github.altoukhovmax.worldapi.entity.attribute.Continent;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class ContinentStringConverter implements AttributeConverter<Continent, String> {

    @Override
    public String convertToDatabaseColumn(Continent continent) {
        return continent == null ? null : continent.getDisplayName();
    }

    @Override
    public Continent convertToEntityAttribute(String s) {
        return s == null ? null : Continent.fromDisplayName(s);
    }
}
