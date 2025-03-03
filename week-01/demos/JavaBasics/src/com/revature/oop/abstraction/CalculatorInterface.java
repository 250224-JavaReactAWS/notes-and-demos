package com.revature.oop.abstraction;

public interface CalculatorInterface {
    // Notice that this is NOT a class, this is an interface

    /*
    What is an Interface in Java?
    An Interface is similar to a contract. It provides a list of methods that all implementing classes must fill out
    Generally there are no implementations for methods here (all methods are ABSTRACT)

    All methods in an interface are PUBLIC and ABSTRACT by default
     */

    int add(int a, int b);

    int subtract(int a, int b);

    int multiply(int a, int b);

    // Interfaces outline the methods required inside an implementing class
}
