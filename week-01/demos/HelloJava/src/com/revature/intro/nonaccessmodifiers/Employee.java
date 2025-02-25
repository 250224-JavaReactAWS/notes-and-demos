package com.revature.intro.nonaccessmodifiers;

public class Employee {

    // Let's say all of these employees belong to the same company
    // They all share the same value for company name
    static String companyName = "Revature";

    String name;

    String position;

    double salary;

    // All-Args constructor
    public Employee(String name, String position, double salary){
        this.name = name;
        this.position = position;
        this.salary = salary;
    }
}
