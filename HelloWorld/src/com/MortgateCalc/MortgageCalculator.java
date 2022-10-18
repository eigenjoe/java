package com.MortgateCalc;

public class MortgageCalculator {

    private float principal;
    private float annualRate;

    private byte periodInYears;

    public byte getMONTHS_IN_YEAR() {
        return MONTHS_IN_YEAR;
    }
    public byte getPeriodInYears() {
        return periodInYears;
    }
    private final byte MONTHS_IN_YEAR = 12;
    private final byte PERCENT = 100;

    public MortgageCalculator(float principal, float annualRate, byte periodInYears) {
        this.principal = principal;
        this.annualRate = annualRate;
        this.periodInYears = periodInYears;
    }

    public double calculateMortgagePayment() {
        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        short periodInMonths = getPeriodInMonths();

        float result = (float) (principal *
                        ( (monthlyRate * Math.pow((1 + monthlyRate), periodInMonths)) /
                        ((Math.pow((1 + monthlyRate), periodInMonths)) - 1)));

        return result;
    };

    public float calculateRemainingBalance( short numberOfPaymentsMade ) {

        float monthlyRate = annualRate / PERCENT / MONTHS_IN_YEAR;
        short periodInMonths = getPeriodInMonths();

        float remainingBalance = (float) (principal *
                        ( Math.pow((1 + monthlyRate), periodInMonths) - Math.pow((1 + monthlyRate), numberOfPaymentsMade) ) /
                        (Math.pow((1 + monthlyRate), periodInMonths) - 1));

        return remainingBalance;
    }

    private short getPeriodInMonths() {
        return (short) (periodInYears * MONTHS_IN_YEAR);
    }

    public float[] calculateRemainingPayments() {

        float[] remainingPayments = new float[getPeriodInMonths()];
        for (short month = 1; month < remainingPayments.length; month++) {
            float balance = calculateRemainingBalance(month);
            remainingPayments[month - 1] = balance;
        }

        return remainingPayments;
    }
}
