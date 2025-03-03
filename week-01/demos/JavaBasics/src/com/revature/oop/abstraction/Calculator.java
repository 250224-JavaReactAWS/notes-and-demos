package com.revature.oop.abstraction;

public class Calculator implements CalculatorInterface{
    // NOTICE: We EXTEND Classes and IMPLEMENT interfaces

    /*
    In an implementing class we need to provide a method body for ALL abstract methods so when they're called they
    have an implementation
     */

    @Override
    public int add(int a, int b) {
        return a+b;
    }

    @Override
    public int subtract(int a, int b) {
        return a-b;
    }

    @Override
    public int multiply(int a, int b) {
        return a*b;
    }

    public int square(int c){
        return c*c;
    }


}
