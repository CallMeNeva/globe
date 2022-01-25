// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import java.util.Objects;
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

    public static Continent of(String name) {
        return Stream.of(values())
                .filter(continent -> Objects.equals(continent.displayName, name))
                .findAny()
                .orElseThrow(() -> new NoSuchContinentException("Continent '" + name + "' does not exist"));
    }

    @Override
    public String toString() {
        return displayName;
    }
}
