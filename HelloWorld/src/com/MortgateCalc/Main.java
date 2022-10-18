package com.MortgateCalc;

public class Main {
    public static void main(String[] args) {

        final float PRINCIPAL_MAX = 1_000_000F;
        final float PRINCIPAL_MIN = 1_000F;

        final float ANNUAL_RATE_MAX = 30F;
        final float ANNUAL_RATE_MIN = 0F;

        final byte PERIOD_IN_YEARS_MAX = 30;
        final byte PERIOD_IN_YEARS_MIN = 1;

        float principal = (float) Console.readNumber("Principal ($1K - $1M): ", PRINCIPAL_MIN, PRINCIPAL_MAX);
        float annualRate = (float) Console.readNumber("Annual Interest Rate: ", ANNUAL_RATE_MIN, ANNUAL_RATE_MAX);
        byte periodInYears = (byte) Console.readNumber("Period (Years): ", PERIOD_IN_YEARS_MIN, PERIOD_IN_YEARS_MAX);

        var calculator = new MortgageCalculator(principal,annualRate, periodInYears);
        var report = new MortgageReport(calculator);
        report.printMortgagePayment();
        report.printPaymentSchedule();
    }

}
