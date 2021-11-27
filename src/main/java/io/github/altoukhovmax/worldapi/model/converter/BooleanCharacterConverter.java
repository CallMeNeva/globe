package io.github.altoukhovmax.worldapi.model.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class BooleanCharacterConverter implements AttributeConverter<Boolean, Character> {

    private static final char TRUE_CHAR_VALUE = 'T';
    private static final char FALSE_CHAR_VALUE = 'F';

    @Override
    public Character convertToDatabaseColumn(Boolean b) {
        return b == null ? null : (b ? TRUE_CHAR_VALUE : FALSE_CHAR_VALUE);
    }

    @Override
    public Boolean convertToEntityAttribute(Character c) {
        return c == null ? null : switch (c) {
            case TRUE_CHAR_VALUE -> Boolean.TRUE;
            case FALSE_CHAR_VALUE -> Boolean.FALSE;
            default -> throw new IllegalArgumentException("Expected '" + TRUE_CHAR_VALUE + "' or '" + FALSE_CHAR_VALUE + '\'');
        };
    }
}
