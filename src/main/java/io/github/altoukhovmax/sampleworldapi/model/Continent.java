package io.github.altoukhovmax.sampleworldapi.model;

import java.util.stream.Stream;

public enum Continent {
    ASIA("Asia"),
    EUROPE("Europe"),
    NORTH_AMERICA("North America"),
    AFRICA("Africa"),
    OCEANIA("Oceania"),
    ANTARCTICA("Antarctica"),
    SOUTH_AMERICA("South America");

    private final String displayName;

    Continent(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public static Continent fromDisplayName(String name) {
        return Stream.of(values())
                .filter(continent -> continent.getDisplayName().equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("Unexpected value: '" + name + '\''));
    }
}