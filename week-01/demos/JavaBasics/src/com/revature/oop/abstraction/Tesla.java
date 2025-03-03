package com.revature.oop.abstraction;

public class Tesla extends Car{

    // In this class we need to provide a body for the drive method
    @Override
    public void drive() {
        System.out.println("The electric tesla drove quietly");
    }
}
