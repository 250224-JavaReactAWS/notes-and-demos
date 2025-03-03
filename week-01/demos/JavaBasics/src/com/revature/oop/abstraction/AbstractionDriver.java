package com.revature.oop.abstraction;

public class AbstractionDriver {

    /*
    Our final pillar of OOP is abstraction which involves abstracting away implementation for the use of a simplified
    interface. I.e. make things simpler by hiding implementation details

    A good example of abstraction in the real world is driving a car.

    Abstraction in Java is achieved through Abstract Classes and Interfaces
     */

    public static void main(String[] args){
        // With abstraction the idea is to have a simplified interface that allows you to swap implementations
        // easily and not worry about the details

        // Interface variableName = new implementingClass();
        CalculatorInterface calculator = new Calculator();
        // What is the benefit of this?
        // I know the calculator variable is of type calculator interface so I can any method declared in
        // calculator interface without worrying about it being implemented

        System.out.println(calculator.add(1,2));
        System.out.println(calculator.subtract(9,6));
        System.out.println(calculator.multiply(4,3));
//        calculator.square();
        // The above method is NOT accessible since it is not defined in the CalculatorInterface

        // With abstraction I can swap the Calculator implementing class for ANY implementing class and it'll be
        // guaranteed to work with no other swaps

        // Situation where we can leverage this:
        // LinkedList vs ArrayList
        // ArrayLists store information under the hood in an Array, meaning it's fast for retreiving data but slow
        // for insertions/deletions. LinkedLists are a series of nodes and pointers meaning they're good for insertion
        // and deletion but slower for retrieval. Both implement the List interface so they can be swapped whenever


        // Let's try to make a Car
//        Car c1 = new Car();
        // This doesn't work because car is abstract so we need to provide an implementing class

        Car c1 = new Tesla();

        c1.honkHorn();
        c1.drive();

        // Because I used the Car abstract class it doesn't matter WHAT the implementing class is, I can guarantee
        // that it will be able to drive since all implementing classes need to provide that method.
    }
}
