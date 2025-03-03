package com.revature.classes;
// When using packages to organize code, the first line now consists of the package this class belongs to

public class Main {
    public static void main(String[] args) {
        /*
        Classes and Objects
        Last week, we introduced our first Java variables by using primitive values which are small pieces of
        simple data that contain just a value and nothing else

        Today we're going to make things more complex and start about classes and objects.
        Java is an Object-Oriented Programming Language meaning it focuses on classes and objects. Our goal is to
        create a blueprint for real world things and call it a class and we'll create instances of those classes called
        objects
         */

        // To create our very first object we'll use the constructor for the class with the `new` keyword
        Person johnSmith = new Person();
        // This calls the class constructor which is a special method that creates an object and returns the Person

        // We can access all of the fields we outlined before
        johnSmith.name = "John Smith";
        johnSmith.age = 27;
        johnSmith.height = 5.75;
        johnSmith.weight = 150.25;
        johnSmith.isMarried = true;

        // Here we've set all the different values for this object
        // We can create a second object that holds all of its own data as well
        Person janeDoe = new Person();

        janeDoe.name = "Jane Doe";

        System.out.println(johnSmith.name);
        System.out.println(janeDoe.name);

        /*
        Our goal once we start building web apps is to design models that hold all the necessary data for whatever
        object and track it inside the application
        Users
        Accounts
        Items in a store
        IT Tickets
         */

        // TODO Come back to this later
        System.out.println(johnSmith);
        System.out.println(janeDoe);

        // There are methods associated with the person class now that we can use to introduce the person
//        johnSmith.introduce();
//        janeDoe.introduce();

        System.out.println(johnSmith.introduce());
        System.out.println(janeDoe.introduce());


        janeDoe.age = 21;
        janeDoe.birthday(); // 22
        janeDoe.birthday(); // 23
        janeDoe.birthday(); // 24

        // Using the constructor I can create an object with all of its fields filled out
        Person kaitlyn = new Person("Kaitlyn Graves", 23, 5.5, 130, false);

        System.out.println(kaitlyn.introduce());

        kaitlyn.birthday();
        kaitlyn.birthday();
        kaitlyn.birthday();
        kaitlyn.birthday();
    }

}