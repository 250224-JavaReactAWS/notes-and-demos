package com.revature.oop.inheritance;

public class Dog extends Animal{

    // Dogs are animals so it makes sense for a dog to be able to do and have all the fields that a generic animal
    // has. So this class will EXTEND the parent class (that means this class is a child class / sub class)

    // Let's create a method that accesses variables from the parent class
    public void speak(){
        System.out.println("The dog named " + name + " has started barking!");
    }

    // Constructor
    // No-args (no arguments) constructor, which takes in no arguments and just creates an object
    // This is the default constructor, every class will have this automatically if no other constructor is defined
    public Dog(){

    }

    // All-args (all arguments) constructor
    // This allows us to set the values for our dog
    public Dog(String name, String species, int numberOfLegs){
        // We can assign the values for the instance variables as the following
        this.name = name;
        this.species = species;
        this.numberOfLegs = numberOfLegs;
        // The `this.` refers to the object itself whereas the variables on the right are the method arguments
    }

    // Since most dogs have 4 legs, it makes sense to set the value to 4 automatically
    public Dog(String name, String species){
        this.name = name;
        this.species = species;
        this.numberOfLegs = 4; // Default value of 4 legs
    }
}

