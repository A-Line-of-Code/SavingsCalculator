package com.example.savingscalculator;

public class Calculate {
    private double goal, income, expenses, rateOfSaving;
    private String currency;

    public Calculate(double goal, double income, double expenses, double rateOfSaving, String currency) {
        this.goal = goal;
        this.income = income;
        this.expenses = expenses;
        this.rateOfSaving = rateOfSaving / 100;
        this.currency = currency;
    }

    public double calculateGoalWithCurrency(double goal, String currency) {
        if (currency.equals("USD")) {
            return goal * 0.64;
        }
        else if (currency.equalsIgnoreCase("AUD")) {
            return goal * 0.94;
        }
        else if (currency.equalsIgnoreCase("EUR")) {
            return goal * 0.57;
        }
        else if (currency.equalsIgnoreCase("GBP")) {
            return goal * 0.52;
        }
        else if (currency.equalsIgnoreCase("NZD")) {
            return goal; // default currency
        }
        else { // error
            return -1;
        }
    }

    public double calculateIncomeAfterTax(double income) {
        if ((income * 52) <= 14000) {
            return income - (0.105 * income);
        }
        else if ((income * 52) > 14000  && (income * 52) <= 48000) {
            return income - (0.175 * income);
        }
        else if ((income * 52) > 48000  && (income * 52) <= 70000) {
            return income - (0.3 * income);
        }
        else if ((income * 52) > 70000) {
            return income - (0.33 * income);
        }
        else { // error
            return -1;
        }
    }

    public double calculateSavings(double income, double expenditure, double rateOfSaving) {
        return rateOfSaving * (income - expenditure);
    }

    public int calculateWeeks(double goal, double savings) {
        return (int)Math.ceil(goal / savings);
    }

    @Override
    public String toString() {
        return  "\nGoal: " + goal +
                "\nCurrency: " + currency +
                "\nIncome: " + income +
                "\nExpenses: " + expenses +
                "\nPercent: " + rateOfSaving;
    }

    public double getGoal() {
        return goal;
    }

    public void setGoal(double goal) {
        this.goal = goal;
    }

    public double getIncome() {
        return income;
    }

    public void setIncome(double income) {
        this.income = income;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getRateOfSaving() {
        return rateOfSaving;
    }

    public void setRateOfSaving(double rateOfSaving) {
        this.rateOfSaving = rateOfSaving;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
