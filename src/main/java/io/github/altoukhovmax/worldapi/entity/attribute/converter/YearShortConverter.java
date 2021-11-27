package io.github.altoukhovmax.worldapi.entity.attribute.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.time.Year;

@Converter(autoApply = true)
public class YearShortConverter implements AttributeConverter<Year, Short> {

    @Override
    public Short convertToDatabaseColumn(Year year) {
        return year == null ? null : (short) year.getValue();
    }

    @Override
    public Year convertToEntityAttribute(Short sh) {
        return sh == null ? null : Year.of(sh);
    }
}
