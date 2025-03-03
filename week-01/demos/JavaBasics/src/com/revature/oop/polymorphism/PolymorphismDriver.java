package com.revature.oop.polymorphism;

public class PolymorphismDriver {

    /*
    Polymorphism is out second pillar of OOP. It means "many-forms" and it's defined as code being able to be reused
    indifferent contexts but with the same name.

    Two Main ways this is achieved
        - Method Overriding
            - Takes a parent class method and provide new functionality in a child class
        - Method Overloading
            - Multiple methods in the same class sharing a name, but a different set of parameters
     */

    public static void main(String[] args){
        // Let's create a couple of objects
        Dog dog = new Dog();

        // Call the methods from dog
        dog.makeSound(); // This method has been overridden in the child class
        dog.move(10);

        Cat cat = new Cat();

        // Call the methods from cat
        cat.makeSound();
        cat.move(10);

        // Let's make a few more dogs
        Dog cash = new Dog();
        Dog mya = new Dog("Mya", 9, "Boxer");
        Dog brody = new Dog("Brody", "Bulldog");

        // The constructor has been overloaded to accept multiple forms and creates the object differently depending
        // on how you call it

        // Let's look at printing objects and checking equality before we go anywhere
        System.out.println(cash);
        System.out.println(mya);
        System.out.println(brody);

        // Let's create another dog and check equality
        Dog mya2 = new Dog("Mya", 9, "Boxer");
        System.out.println("Does mya equal mya2? " + (mya.equals(mya2)));
        // What's going on here? Why can't we check equality correctly and why can't we print the objects?
        // The Object Class
    }
}
