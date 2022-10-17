package com.MortgateCalc;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final float PRINCIPAL_MAX = 1_000_000F;
        final float PRINCIPAL_MIN = 1_000F;

        final float ANNUAL_RATE_MAX = 30F;
        final float ANNUAL_RATE_MIN = 0F;

        final byte PERIOD_IN_YEARS_MAX = 30;
        final byte PERIOD_IN_YEARS_MIN = 1;

        float principal = (float) readNumber("Principal ($1K - $1M): ", PRINCIPAL_MIN, PRINCIPAL_MAX);
        float annualRate = (float) readNumber("Annual Interest Rate: ", ANNUAL_RATE_MIN, ANNUAL_RATE_MAX);
        short periodInYears = (short) readNumber("Period (Years): ", PERIOD_IN_YEARS_MIN, PERIOD_IN_YEARS_MAX);

        double mortgage = MortgageCalculator.calculateMortgagePayment(principal,annualRate, periodInYears);
        MortgageCalculator.printMortgagePayment(mortgage);
        MortgageCalculator.printPaymentSchedule(principal, annualRate, periodInYears);
    }

    public static double readNumber(String prompt, double min, double max) {
        Scanner scanner = new Scanner(System.in);
        double input;
        while (true) {
            System.out.print(prompt);
            input = scanner.nextDouble();
            if (input >= min && input <= max) {
                break;
            }
            System.out.println("Enter a value between " + min + " and " + max + ".");
        }
        return input;
    }

}
