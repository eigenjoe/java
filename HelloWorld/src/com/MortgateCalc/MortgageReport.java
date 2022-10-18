package com.MortgateCalc;

import java.text.NumberFormat;

public class MortgageReport {
    private MortgageCalculator calculator;
    private NumberFormat currency;
    public MortgageReport( MortgageCalculator calculator) {
        this.calculator = calculator;
        this.currency = NumberFormat.getCurrencyInstance();
    }


    public void printMortgagePayment() {
        double mortgage = calculator.calculateMortgagePayment();
        String formattedMortgage = currency.format(mortgage);
        System.out.println("MORTGAGE:");
        System.out.println("----------");
        System.out.println("Monthly Payment: " + formattedMortgage);
    }

    public void printPaymentSchedule() {

        short periodInMonths = (short)(calculator.getPeriodInYears() * calculator.getMONTHS_IN_YEAR());

        System.out.println("PAYMENT SCHEDULE");
        System.out.println("_________________");
        float[] remainingBalances = calculator.calculateRemainingPayments();
        for (float balance : remainingBalances )  {
            String formattedBalance = currency.format(balance);
            System.out.println(formattedBalance);
        }
    }
}
