package com.revature.classes;

public class Person {
    /*
    This is our first example of a custom class.

    Classes are blueprints for objects. They outline both the different attributes/fields an object has
    and the different abilities/behaviors the object can perform (methods)
     */

    // Fields are attributes that belong the object
    // Name, age, height, weight, isMarried
    // Every person will have a value for ALL of these fields
    String name;

    int age;

    double height;

    double weight;

    boolean isMarried;

    // Methods
    // Methods are functions that belong to a class, they outline behaviors the object can take or can be performed
    // upon the object itself

    // Method signature structure
    // [access modifier] [non-access modifiers] [return type] [name] ([parameters]){}
    // public static void main(String[] args){}

    // Todo Introduction method
    // This will use the value for the Person's name and introduce them
    public String introduce(){
        // This method is a PUBLIC method that returns a STRING and takes in 0 arguments
        return "Hello! My name is " + name;
    }

    // Todo Birthday Method
    // This will update the age variable and make it a year older
    public void birthday(){
        // This method is PUBLIC and returns VOID meaning it cannot return a value;
        // Update the age
        age += 1;

        System.out.println("Happy Birthday! " + name + " is now " + age +" years old!");
    }

    /*
    Constructors

    Constructors are special methods (with the same name as the class) that exist inside classes that allow you to
    create an instance of the object

    The default constructor is a NO-ARGS constructor meaning it takes in no-arguments.

    We can create more constructors to initialize values in our fields for the object itself
     */

    // All-Args Constructor
    public Person(String name, int age, double height, double weight, boolean isMarried){
        // We set all of the values that are passed
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.isMarried = isMarried;
        // this. refers to the instance variables of the object itself

    }

    // The default no-args constructor ONLY exists if there are no other constructors, if we create another one
    // we can re-add the no-args constructor manually
    public Person(){
        // We don't initialize any values here
    }


}
