package com.revature.intro.nonaccessmodifiers;

public class Calculator {
    // We'll use STATIC on the methods inside of the calculator class
    /*
    What does static do?
    Static is a non-access modifier that takes a member (variable or method) and brings it to the class level/scope

    This means the method or variable will belong the class and not to a single object
     */

    public static int add(int a, int b){
        return a + b;
    }
}
