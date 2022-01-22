package com.altoukhov.globe.country;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearShortConverter implements AttributeConverter<Year, Short> {

    // Column defined as nullable: null-checks are required

    @Override
    public Short convertToDatabaseColumn(Year attribute) {
        return attribute == null ? null : (short) attribute.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short dbData) {
        return dbData == null ? null : Year.of(dbData);
    }
}
