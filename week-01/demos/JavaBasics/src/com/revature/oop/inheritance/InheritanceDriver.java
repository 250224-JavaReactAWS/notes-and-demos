package com.revature.oop.inheritance;

public class InheritanceDriver {

    /*
    As previously mentioned, Java is an Object-Oriented Programming Language. With that being said there are 4 pillars
    of OOP that we focus on inside of our code. These are common interview questions so do your best to remember them

    Inheritance is our first pillar and it's the process of a child/subclass inheriting different fields and methods
    from a parent/super class

    This gives us the ability to create general classes that can be more specified later down the line
     */

    public static void main(String[] args){
        Car tesla = new Car("Tesla");
        // If Car is a type of vehicle we should have access to the various fields and methods associated with Vehicle
//        tesla.hasWheels = true;
//        tesla.numberOfWheels = 4;
//        tesla.brand = "Tesla";

        tesla.move(15);
        System.out.println(tesla.hasWheels);
        System.out.println(tesla.numberOfWheels);
        System.out.println(tesla.brand);
    }
}
