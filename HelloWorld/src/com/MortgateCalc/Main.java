package com.MortgateCalc;

import java.text.NumberFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Principal:");
        double principal = scanner.nextDouble();

        System.out.print("Annual Interest Rate: ");
        float annualRate = scanner.nextFloat();

        System.out.print("Period (Years): ");
        byte periodInYears = scanner.nextByte();

        double mortgage = MortgageCalculator.calculateMortgage(principal,annualRate, periodInYears);
        String formattedMortgage = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println(formattedMortgage);


    }
}
