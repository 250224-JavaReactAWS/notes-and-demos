package com.revature.oop.inheritance;

public class InheritanceDriver {
    /*
    Our next set of topics is going to cover the pillars of Object Oriented Programming.

    There are 4 major pillars of OOP and these are frequent interview questions so we need to understand the topics
    and help prepare ourselves

    Pillars: Inheritance, Encapsulation, Polymorphism, and Abstraction

    Inheritance -> A parent class passes down attributes and methods to a child class
    This allows for a more complex class structure and allows for reusable code
     */

    public static void main(String[] args){

        // Let's make a dog
        Dog cash = new Dog();
        cash.name = "Cash";
        cash.species = "Pit Bull";
        cash.numberOfLegs = 4;
        cash.speak();

        // Let's breakdown how we can make this more robust using things like constructors
        // Recall a constructor is a special method for creating an object. This can be used to set the values of
        // instance variables (fields)

        // Now that we've created a constructor we can set all the fields for the dog in one line
        Dog mya = new Dog("Mya", "Boxer", 4);
        mya.speak();

        // Let's create a third dog
        Dog tipzy = new Dog("Tipzy", "Labrador");
        // Let's verify that tipzy has 4 legs
        System.out.println(tipzy.numberOfLegs);


        Bird bert = new Bird("Bert");

        // Since a Bird is a subclass or subtype of Animal I can access the animal class information and methods
        // Bird class methods
        bert.fly(20);

        //Animal class methods
        bert.getInformation();

    }
}
