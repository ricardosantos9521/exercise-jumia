package com.interview.jumia.exercise.entity;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTests {

    Customer c1 = new Customer(1, "Ricardo Santos", "(237) 697151594");
    Customer c2 = new Customer(1, "Test1", "(258) 849181828");
    Customer c3 = new Customer(1, "Test1", "(251) 9119454961");
    Customer c4 = new Customer(1, "Test1", "(251)9119454961");
    Customer c5 = new Customer(1, "Test1", "(222) jfr");

    @Test
    public void getCode() {
        assertEquals("+237", c1.getCode());
        assertEquals("+258", c2.getCode());
        assertEquals("+251", c3.getCode());
        assertEquals(null, c4.getCode());
        assertEquals("+222", c5.getCode());
    }

    @Test
    public void getNumber() {
        assertEquals("697151594", c1.getNumber());
        assertEquals("849181828", c2.getNumber());
        assertEquals("9119454961", c3.getNumber());
        assertEquals(null, c4.getNumber());
        assertEquals("jfr", c5.getNumber());
    }

    @Test
    public void getCountryName() {
        assertEquals("Cameroon", c1.getCountryName());
        assertEquals("Mozambique", c2.getCountryName());
        assertEquals("Ethiopia", c3.getCountryName());
        assertEquals("", c4.getCountryName());
        assertEquals("", c5.getCountryName());
    }

    @Test
    public void getState() {
        assertEquals(true, c1.getState());
        assertEquals(true, c2.getState());
        assertEquals(false, c3.getState());

        assertEquals(false, c4.getState());
        assertEquals(false, c5.getState());
    }

}