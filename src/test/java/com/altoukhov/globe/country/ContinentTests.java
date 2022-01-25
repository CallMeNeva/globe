// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("Continent Tests")
public class ContinentTests {

    @Test
    @DisplayName("Continent::of returns an existing continent")
    public void returnsExistingContinent() {
        Continent expected = Continent.ASIA;
        Continent actual = Continent.of("Asia");

        Assertions.assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Continent::of throws NoSuchContinentException on invalid name")
    public void throwsOnNonexistentContinent() {
        Assertions.assertThrows(NoSuchContinentException.class, () -> Continent.of("Kalimdor"));
    }
}
