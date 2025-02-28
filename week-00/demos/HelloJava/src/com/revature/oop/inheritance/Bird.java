package com.revature.oop.inheritance;

public class Bird extends Animal{

    // Saying that this class extends animal means it has access to all the fields and variables from the animal class

    // Let's make a constructor for the bird
    public Bird(String name){
        this.name = name;
        this.species = "Bird";
        this.numberOfLegs = 2;
    }

    public void fly(int distance){
        System.out.println("The bird " + name + " flew a total of " + distance + " miles");
    }
}
