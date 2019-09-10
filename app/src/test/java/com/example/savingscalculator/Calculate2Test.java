package com.example.savingscalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Calculate2Test {

    private String date, expected, actual;
    private int days;
    private Calculate2 c1;

    @Before
    public void setUp() throws Exception {
        date = "11-09-2019";
        days = 14;
        expected = "24-09-2019";

        c1 = new Calculate2(date, days);
        actual = c1.calculateFinDate(c1.getDate(),c1.getDays());
    }

    @Test
    public void testCalculateFinDate() {
        assertEquals(expected, actual);
    }

    @After
    public void tearDown() throws Exception {
        c1 = null;
    }
}