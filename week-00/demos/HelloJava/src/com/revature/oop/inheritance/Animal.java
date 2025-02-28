package com.revature.oop.inheritance;

public class Animal {
    // This is going to be my PARENT class (sometimes also called a super class)
    // A super class contains general fields and methods that will passed down to child classes

    String name;

    String species;

    int numberOfLegs;

    // Let's create a method as well
    public void getInformation(){
        System.out.println("The animal is named: " + name + ". The species is: " + species);
    }
}
