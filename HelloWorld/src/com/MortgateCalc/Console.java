package com.MortgateCalc;

import java.util.Scanner;

public class Console {
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
