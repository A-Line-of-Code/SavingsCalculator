package com.example.savingscalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

    private double income, tax, percentage, net, expenditure, goal, result;
    private String currency;

    private double expected, actual;
    private Calculate c1;

    @Before
    public void setUp() throws Exception {
        income = 300;
        tax = 17.5;
        percentage = 20;
        net = 247.5;
        expenditure = 50;
        goal = 39.5;
        result = 0;
        currency = "USD";

        c1 = new Calculate();
    }

    @Test
    public void testCalculateTax() {
        actual = c1.calculateTax(income);
        expected = 17.5;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateNet() {
        expected = 247.5;
        actual = c1.calculateNet(income, tax);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateGoal() {
        expected = 39.5;
        actual = c1.calculateGoal(net, expenditure, percentage);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateWeeks() {
        expected = 0;
        actual = c1.calculateWeeks(goal, result);
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateCurrency() {
        expected = 22.3254;
        actual = c1.calculateCurrency(currency, goal);
        assertEquals(expected, actual, 0);
    }

    @After
    public void tearDown() throws Exception {
        c1 = null;
    }
}