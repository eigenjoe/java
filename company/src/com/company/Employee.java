package com.company;

public class Employee {
    private float baseSalary;
    private float hourlyRate;

    public Employee(float baseSalary, float hourlyRate)  {
        setBaseSalary(baseSalary);
        setHourlyRate(hourlyRate);
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(float baseSalary) {
        if ( baseSalary <= 0) {
            throw new IllegalArgumentException("Base Salary cannot be less or equal to 0");
        }
        this.baseSalary = baseSalary;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        if ( hourlyRate <= 0) {
            throw new IllegalArgumentException("Hourly Rate cannot be less or equal to 0");
        }
        this.hourlyRate = hourlyRate;
    }

    public float calculateWage(int extraHours) {
        return baseSalary + ( hourlyRate * extraHours);
    }
    public float calculateWage() {
        return calculateWage(0);
    }
}
