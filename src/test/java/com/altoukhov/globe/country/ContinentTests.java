// SPDX-FileCopyrightText: Copyright 2021-2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package com.altoukhov.globe.country;

import com.altoukhov.globe.country.Continent;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

public class ContinentTests {

    @Test
    public void presentOnValidName() {
        Optional<Continent> continent = Continent.of("Europe");
        Assertions.assertTrue(continent.isPresent());
    }

    @Test
    public void emptyOnInvalidName() {
        Optional<Continent> continent = Continent.of("Kalimdor");
        Assertions.assertTrue(continent.isEmpty());
    }

    @Test
    public void emptyOnNullName() {
        Optional<Continent> continent = Continent.of(null);
        Assertions.assertTrue(continent.isEmpty());
    }
}
