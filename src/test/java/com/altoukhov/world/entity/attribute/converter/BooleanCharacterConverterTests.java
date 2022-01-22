package com.altoukhov.world.entity.attribute.converter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BooleanCharacterConverterTests {

    private static final BooleanCharacterConverter CONVERTER = new BooleanCharacterConverter();

    @Test
    public void convertsAttributeValue() {
        boolean attributeValue = true;
        Assertions.assertEquals('T', CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsValidColumnValue() {
        char columnValue = 'F';
        Assertions.assertEquals(false, CONVERTER.convertToEntityAttribute(columnValue));
    }

    @Test
    public void throwsOnInvalidColumnValue() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> CONVERTER.convertToEntityAttribute('Z'));
    }
}
