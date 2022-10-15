package com.MortgateCalc;

public class MortgageCalculator {

    static double calculateMortgage( double principal, double annualRate, int periodInYears) {
        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENT = 100;

        double monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        int periodInMonths = periodInYears * MONTHS_IN_YEAR;

        double result = principal * ( (monthlyRate * Math.pow((1 + monthlyRate), periodInMonths)) /
                ((Math.pow((1 + monthlyRate), periodInMonths)) - 1));

        return result;
    };


}
