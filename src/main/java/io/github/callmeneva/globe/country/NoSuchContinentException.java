// SPDX-FileCopyrightText: Copyright 2022 Maxim Altoukhov
// SPDX-License-Identifier: MIT

package io.github.callmeneva.globe.country;

import java.util.NoSuchElementException;

public class NoSuchContinentException extends NoSuchElementException {

    public NoSuchContinentException(String message) {
        super(message);
    }
}
