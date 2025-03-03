package com.revature.oop.polymorphism;

public class Pet{
    // This class will be used as a parent class for my 2 kinds of pets

    // Making noise
    public void makeSound(){
        System.out.println("The animal makes some noise");
    }

    // Moving
    public void move(int distance){
        System.out.println("The animal moved " + distance + " feet.");
    }
}
