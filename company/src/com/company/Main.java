package com.company;

public class Main {
    public static void main(String[] args) {

        var joe = new Employee(150000, 126);

        double wage = joe.calculateWage(10);

        System.out.println(wage);
    }
}
