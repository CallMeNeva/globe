package io.github.altoukhovmax.sampleworldapi.model.converter;

import io.github.altoukhovmax.sampleworldapi.model.Continent;

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
