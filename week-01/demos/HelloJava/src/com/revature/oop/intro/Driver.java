package com.revature.oop.intro;

public class Driver {

    /*
    A driver class or a launcher class are classes that contain a main method that allow you to use apply the things
    you develop throughout your application


    Class vs Objects in Java
    Everything in Java will live inside of a class or a class-like structure
    Anytime we make an instance of a class we create what is called an object
     */

    public static void main(String[] args){
        // The main method is the entry point for our application so we write all the code we want executed in here

        // To create a person (or any other class) we'll use the class's constructor which is a special method
        // that allows you to create an object. We use this by using the `new` keyword

        Person johnSmith = new Person();
        // Notice the DATATYPE is Person, the class we created and the right side includes Person() which is the
        // constructor method

        // We can access and set all of the values for the variable
        johnSmith.name = "John Smith";
        johnSmith.height = 5.5;
        johnSmith.weight = 200;
        johnSmith.age = 27;
        johnSmith.isMarried = false;
        // In this case the variable johnSmith is a virtual representation of a person with the associated values above

        Person janeDoe = new Person();
        janeDoe.name = "Jane Doe";
        janeDoe.age = 25;

        // The goal here is to use the blueprint and create objects that represent real world things
        // Accounts
        // Bank Record
        // Item in an ecommerce store
        // Anything you can describe in code

        // Now that the introduction method exists I can call it on my individual people
        johnSmith.introduction();
        janeDoe.introduction();

        // Let's let johnSmith get married
        System.out.println("Is John Smith married? " + johnSmith.isMarried);
        johnSmith.getMarried();
        System.out.println("Is John Smith married? " + johnSmith.isMarried);

        // Let's call the move method
        janeDoe.move(6);
        // This method returns a string but does not print anything out
        // Let's print the returned string
        System.out.println(janeDoe.move(6));
    }
}
