package com.revature.oop.inheritance;

public class Car extends Vehicle {
    // We want to declare that a Car is a subtype of vehicle
    // We need to EXTEND the vehicle class

    // Car now has access to all of the methods and variables associated with the vehicle class

    // Once we added in the constructor to the vehicle class we need to provide the values from the child class object
    // to the parent class constructor
    // The first line in any constructor is implicitly super() which is a reference to the parent class constructor

    public Car(String brand){
        super(true, 4, brand);

        // Whenever we create a car object, the vehicle object is created first so we pass in information to the
        // constructor for the vehicle class
    }

    // HONK Method
    public void soundHorn(){
        System.out.println("BEEEEEEEEEP");
    }
}
