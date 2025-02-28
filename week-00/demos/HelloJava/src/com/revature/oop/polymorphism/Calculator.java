package com.revature.oop.polymorphism;

public class Calculator {

    // The next thing I want to show off is Method OVERLOADING
    // We take a method and provide multiple use cases for it by changing the number and types of parameters

    public int add(int a, int b){
        // Recall since this method is NOT void, we need to return an int
        return a + b;
    }

    // With OVERLOADING we have multiple methods with the exact same name that take in different arguments
    public int add(int c){
        return c + c;
    }

    public int subtract(int a, int b){
        return a - b;
    }

}
