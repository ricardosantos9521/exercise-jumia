package com.interview.jumia.exercise.countries;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Country {
    private String name;
    private Pattern pattern;
    private String countryCode;

    public Country(String name, String countryCode, String pattern) {
        this.name = name;
        this.countryCode = countryCode;
        this.pattern = Pattern.compile(pattern);
    }

    public String getName() {
        return this.name;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public boolean isValidNumber(String phone) {
        Matcher r = pattern.matcher(phone);
        if (r.matches()) {
            return true;
        }
        return false;
    }
}
