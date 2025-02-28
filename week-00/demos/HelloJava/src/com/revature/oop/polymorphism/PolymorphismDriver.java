package com.revature.oop.polymorphism;

public class PolymorphismDriver {
    /*
    Our next Pillar of OOP is called Polymorphism

    Polymorphism -> Many forms, but it's the ability for code to change its functionality depending on how it's called

    Overriding -> Changing the implementation of a parent class method in a child class

    Overloading -> Having multiple methods with the same name, but a different number of parameters
     */

    public static void main(String[] args){

        // Let's create an instance of each class
        Paramedic firstResponder1 = new Paramedic();

        Police firstResponder2 = new Police();

        // When I call save the day on these objects they should save the day in DIFFERENT ways
        firstResponder1.saveTheDay();
        firstResponder2.saveTheDay();

        // Right now lets create a calculator and attempt to add and subtract some numbers
        Calculator calculator = new Calculator();

        System.out.println(calculator.add(5,6)); // 11
        System.out.println(calculator.subtract(9,3)); // 6
        // We have now overloaded the add method so let's try it with some new parameters
        System.out.println(calculator.add(7)); // 14
    }
}
