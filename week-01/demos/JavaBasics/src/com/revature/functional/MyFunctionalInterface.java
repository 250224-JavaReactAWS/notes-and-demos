package com.revature.functional;

@FunctionalInterface // This is optional but let's the compiler know there should only be one method in here
public interface MyFunctionalInterface {

    // Functional interfaces are interfaces with one abstract method inside of them
    int doMath(int a, int b);
}
