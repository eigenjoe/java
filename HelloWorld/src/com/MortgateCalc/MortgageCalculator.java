package com.MortgateCalc;

import java.text.NumberFormat;

public class MortgageCalculator {

    static final byte MONTHS_IN_YEAR = 12;
    static final byte PERCENT = 100;

    public static double calculateMortgagePayment( double principal, double annualRate, int periodInYears) {


        double monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        short periodInMonths = (short)(periodInYears * MONTHS_IN_YEAR);

        double result = principal * ( (monthlyRate * Math.pow((1 + monthlyRate), periodInMonths)) /
                ((Math.pow((1 + monthlyRate), periodInMonths)) - 1));

        return result;
    };

    public static double calculateRemainingBalance(
            double principal,
            float annualRate,
            byte periodInYears,
            short numberOfPaymentsMade) {

        double monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        short periodInMonths = (short)(periodInYears * MONTHS_IN_YEAR);

        double remainingBalance = principal *
                ( Math.pow((1 + monthlyRate), periodInMonths) - Math.pow((1 + monthlyRate), numberOfPaymentsMade) ) /
                (Math.pow((1 + monthlyRate), periodInMonths) - 1);

        return remainingBalance;
    }

    public static void printPaymentSchedule(double principal,
                                            float annualRate,
                                            short periodInYears) {

        short periodInMonths = (short)(periodInYears * MONTHS_IN_YEAR);

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_________________");
        for (short i = 1; i <= periodInMonths; i++)  {

            double remainingBalance = calculateRemainingBalance(principal, annualRate, (byte) periodInYears, i);

            String formattedBalance = NumberFormat.getCurrencyInstance().format(remainingBalance);
            System.out.println(formattedBalance);
        }
    }
}
