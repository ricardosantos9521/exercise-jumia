package com.interview.jumia.exercise.countries;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CountriesTests {

    @Test
    public void getCountryNameWithCountryCode() {
        assertEquals("Cameroon", Countries.getCountryName("+237"));
        assertEquals("Ethiopia", Countries.getCountryName("+251"));
        assertEquals("", Countries.getCountryName("+922"));
    }

    @Test
    public void isValidNumber() {

        // valid
        assertEquals(true, Countries.isValidNumber("+237", "(237) 697151594"));
        assertEquals(true, Countries.isValidNumber("+256", "(256) 775069443"));

        // invalid
        assertEquals(false, Countries.isValidNumber("+256", "775069443"));
        assertEquals(false, Countries.isValidNumber("373", "37"));
        assertEquals(false, Countries.isValidNumber("+237", "ahaha"));
        assertEquals(false, Countries.isValidNumber("(258)", "823747618"));
    }
}