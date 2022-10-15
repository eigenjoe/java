package com.MortgateCalc;

import java.text.NumberFormat;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final float PRINCIPAL_MAX = 1_000_000F;
        final float PRINCIPAL_MIN = 1_000F;

        final float ANNUAL_RATE_MAX = 30F;
        final float ANNUAL_RATE_MIN = 0F;

        final byte PERIOD_IN_YEARS_MAX = 30;
        final byte PERIOD_IN_YEARS_MIN = 1;

        float principal;
        float annualRate;
        byte periodInYears;

        while (true) {

            System.out.print("Principal ($1K - $1M):");
            principal = scanner.nextFloat();
            if (principal >= PRINCIPAL_MIN && principal <= PRINCIPAL_MAX )
                break;
            System.out.println("Enter a number between 1,000 and 1,000,000.");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualRate = scanner.nextFloat();
            if (annualRate > ANNUAL_RATE_MIN && annualRate <= ANNUAL_RATE_MAX)
                break;
            System.out.println("Enter a value greater than 0 and less or equal to 30.");
        }

        while (true) {
            System.out.print("Period (Years): ");
            periodInYears = scanner.nextByte();

            if (periodInYears >= PERIOD_IN_YEARS_MIN && periodInYears <= PERIOD_IN_YEARS_MAX)
                break;
            System.out.println("Enter a value between 1 and 30");
        }



        double mortgage = MortgageCalculator.calculateMortgage(principal,annualRate, periodInYears);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(formattedMortgage);


    }
}
