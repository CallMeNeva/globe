package com.globe.country;

import java.util.NoSuchElementException;

public class NoSuchContinentException extends NoSuchElementException {

    public NoSuchContinentException(String message) {
        super(message);
    }
}
