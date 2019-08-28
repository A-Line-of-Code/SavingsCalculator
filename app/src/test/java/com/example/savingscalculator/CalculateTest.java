package com.example.savingscalculator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculateTest {

//    private double goal, income, expenditure, rateOfSaving;
    private double goalWithCurrency, incomeAfterTax, savings;
//    private int weeks;
//    private String currency;

    private double expected, actual;
    private Calculate c1;

    @Before
    public void setUp() throws Exception {
        c1 = new Calculate(3100, 900, 150, 12.5, "USD");

        goalWithCurrency = 1984;
        incomeAfterTax = 742.5;
        savings = 74.0625;
    }

    @Test
    public void testCalculateGoalWithCurrency() {
        actual = c1.calculateGoalWithCurrency(c1.getGoal(), c1.getCurrency());
        expected = 1984;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateIncomeAfterTax() {
        actual = c1.calculateIncomeAfterTax(c1.getIncome());
        expected = 742.5;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateSavings() {
        actual = c1.calculateSavings(incomeAfterTax, c1.getExpenses(), c1.getRateOfSaving());
        expected = 74.0625;
        assertEquals(expected, actual, 0);
    }

    @Test
    public void testCalculateWeeks() {
        actual = c1.calculateWeeks(goalWithCurrency, savings);
        expected = 27;
        assertEquals(expected, actual, 0);
    }

    @After
    public void tearDown() throws Exception {
        c1 = null;
    }
}