package com.revature.oop.abstraction;

public class FaultyCalculator implements CalculatorInterface{
    // This class also implements the interface as well

    @Override
    public int add(int a, int b) {
        return a + b + 7;
    }

    @Override
    public int subtract(int a, int b) {
        return a - b - 4;
    }

    @Override
    public int multiply(int a, int b) {
        return a * b + 1;
    }
}
