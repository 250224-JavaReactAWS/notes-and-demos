package com.revature.oop.polymorphism;

public class Dog extends Pet{

    // Fields
    String name;
    int age;
    String breed;

    /*
    At this point both Dog and Cat have access to the general methods in Pet, but we want to make them more specific
    inside each child class because Dogs and Cats make noise and move very differently

    We want to OVERRIDE the parent method
     */

    @Override // Telling the compiler this overrides a parent class method
    public void makeSound(){
        System.out.println("The dog barks loudly!");
    }

    @Override
    public void move(int distance){
        System.out.println("The dog happily ran " + distance + " feet.");
    }

    // Overloading is the use of multiple methods with different parameters
    // Any set of methods with the same name but different parameters: Constructors

    // No-Args Constructor
    public Dog(){
        this.name = "Default name";
        this.age = 1;
        this.breed = "Default breed";
    }

    // All-Args Constructor
    public Dog(String name, int age, String breed){
        this.name=name;
        this.age=age;
        this.breed=breed;
    }

    public Dog(String name, String breed){
        this.name=name;
        this.breed=breed;
        this.age=1;
    }

    // All of the methods listed above have the exact same name but take it different parameters

    /*
    The Object Class

    All classes inside of Java implicitly extend the Object class. This is the parent level class for EVERY class in
    Java

    This means we have access to a whole bunch of methods that exist inside of the Object class that are free to be
    overridden
    - equals
    - toString
    - hashcode
    - clone

    The two most important that we'll keep track of is equals and toString.

    Default functionality:
        - equals
            - This is the same as == by default, it checks if two objects share the same memory address
        - toString
            - Default functionality is to print the memory address of the object
     */

    // Let's override

    @Override
    public boolean equals(Object obj) {
        // This method originally checks if two variables are in the same place in memory, we actually want to check
        // the values
      // Let's turn the object into a Dog

        // REMINDER: Use .equals for objects (Strings) and == for primitives (ints, char, doubles, etc)
      Dog dog2 = (Dog) obj;
      if (!this.name.equals(dog2.name)){
          return false;
      }
      if (this.age != dog2.age){
          return false;
      }
      if (!this.breed.equals(dog2.breed)){
          return false;
      }
      return true; // The objects share the same value
    }

    @Override
    public String toString() {
//        return super.toString();
        // Normally this returns the memory address of the object, we want to actually print the values itself

        return "Dog {name = " + this.name + ", age = " + this.age + ", breed = " + this.breed + "}";
    }
}
