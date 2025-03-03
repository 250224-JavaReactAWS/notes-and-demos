package com.revature.oop.inheritance;

public class Vehicle {
    // A vehicle is very general, it can refer to a car, or a bicycle, or a plane
    // Some sort of tool that allows you to move quickly

    // General things about a vehicle
    boolean hasWheels;

    int numberOfWheels;

    String brand;

    // Todo Come back and look at constructors in super classes
    // Constructors set the initial values for the fields
    public Vehicle(boolean hasWheels, int numberOfWheels, String brand){
        this.hasWheels = hasWheels;
        this.numberOfWheels = numberOfWheels;
        this.brand = brand;
    }

    // General methods a vehicle can do
    // Move
    public void move(int feet){
        System.out.println("The vehicle moved a total of " + feet + " feet!");
    }

    // This class will be the super class all of our subclasses inherit from
}
