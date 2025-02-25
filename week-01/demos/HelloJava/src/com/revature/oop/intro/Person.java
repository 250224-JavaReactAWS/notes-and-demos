package com.revature.oop.intro;

public class Person {

    // A class is a blueprint for an object which is a virtual representation of a real world thing

    // Fields
    // Fields are like properties and describe certain things about the object
    // These are just going to be variables that we'll set
    // Name (String), height (double), weight(double), age (int), isMarried (boolean)
    String name;

    double height;

    double weight;

    int age;

    boolean isMarried;

    // Every person that gets created should have these specific values

    // Methods
    // A method can be thought of as a behavior, something the object can DO
    // It's basically just a function

    public void introduction(){
        // This method will allow all of our people to introduce themselves. So let's print out an introduction

        System.out.println("Hello! My name is " + name + " and my age is " + age);
    }

    // Lets add another method that updates the value of a variable
    public void getMarried(){
        // This method will update the value of the isMarried boolean to true
        isMarried = true;
    }

    // Methods are interesting since they give you the ability to repeat code for a variety of inputs
    // Let's breakdown a method signature
    // First is the access modifier (we'll talk more later) just leave this as public for now
    // Next are any non-access modifiers (we'll skip for now) this is optional
    // The return type of the function is next, we use void if the return keyword is skipped
    // name of the function
    // in parentheses, any required inputs

    public String move(int feet){
        // Reading the method signature gives us the following info
        // The method is public, it returns a String value, it's called move, and it takes in a single integer

        String toBeReturned = "The person moved a total of " + feet + " feet.";

        // Since the return type is not VOID we must return some value
        return toBeReturned;
    }
}
