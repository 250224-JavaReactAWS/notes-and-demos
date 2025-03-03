package com.revature.modifiers.nonaccessmodifiers;

public class Employee {

    // This class can contain both static and non-static members. Things that are non-static belong to a specific
    // instance

    static String companyName = "Revature"; // Belongs to the class

    String name; // Belongs to the instance

    public Employee(String name){
        this.name = name;
    }

    // Static method
    // These methods belong to the class itself and should be called without using an instance
    public static void companyGreeting(){
        System.out.println("Hello! I work for " + companyName);
    }
}
