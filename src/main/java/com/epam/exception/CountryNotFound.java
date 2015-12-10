package com.epam.exception;

public class CountryNotFound extends IllegalArgumentException {
    public CountryNotFound(String s) {
        super(s);
    }
}
