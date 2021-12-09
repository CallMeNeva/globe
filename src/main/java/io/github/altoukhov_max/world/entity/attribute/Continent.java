package io.github.altoukhov_max.world.entity.attribute;

import java.util.Optional;
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

    public String displayName() {
        return displayName;
    }

    public static Optional<Continent> of(String name) {
        return Stream.of(values())
                .filter(continent -> continent.displayName().equals(name))
                .findAny();
    }
}
