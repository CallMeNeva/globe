package com.altoukhov.globe.entity.attribute.converter;

import com.altoukhov.globe.entity.attribute.Continent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ContinentStringConverterTests {

    private static final ContinentStringConverter CONVERTER = new ContinentStringConverter();

    @Test
    public void convertsAttributeValue() {
        Continent attributeValue = Continent.EUROPE;
        Assertions.assertEquals("Europe", CONVERTER.convertToDatabaseColumn(attributeValue));
    }

    @Test
    public void convertsValidColumnValue() {
        String columnValue = "Europe";
        Assertions.assertEquals(Continent.EUROPE, CONVERTER.convertToEntityAttribute(columnValue));
    }

    @Test
    public void throwsOnInvalidColumnValue() {
        Assertions.assertThrows(IllegalStateException.class, () -> CONVERTER.convertToEntityAttribute("Kalimdor"));
    }
}
