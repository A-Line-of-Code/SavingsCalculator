package com.example.savingscalculator;

public class Calculate {
    public static double calculateCurrency(String currency, double goal) {
        if (currency.equals("USD"))
            return goal + (55.520 * goal) / 100.0;
        else if (currency.equals("AUD"))
            return goal + (05.06 * goal) / 100.0;
        else if (currency.equals("EUR"))
            return goal + (73.739 * goal) / 100.0;
        else if (currency.equals("GBP"))
            return goal + (87.785 * goal) / 100.0;
        else
            return goal;
    }
    public static double calculateTax(double income) {
        if ((income * 52) <= 14000)
            return 10.5;
        else if ((income * 52) > 14000 && (income * 52) <= 48000)
            return 17.5;
        else if ((income * 52) > 48000 && (income * 52) <= 70000)
            return 30;
        else
            return 33;
    }
    public static double calculateNet(double income, double tax) {
        return income - (tax * income) / 100.0;
    }
    public static double calculateGoal(double net, double expenditure, double percentage) {
        return (percentage * (net - expenditure)) / 100.0;
    }
    public static double calculateWeeks(double goal, double result) {
        return goal / result;
    }
}