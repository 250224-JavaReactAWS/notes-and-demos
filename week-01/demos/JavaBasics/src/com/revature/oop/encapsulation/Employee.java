package com.revature.oop.encapsulation;

public class Employee {

    // Marking these fields as private is the first step in encapsulation. It prevents unwanted access entirely

    private int age;

    private String email;

    private String password;

    // Getters
    // Methods declared to allow you to read the value within the fields of the private members
    public int getAge(){
        return this.age;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPassword(){
        return this.password;
    }

    // Setters
    // Setters are methods that allow you to update the instance fields, we create these methods to prevent unwanted or
    // incorrect variable manipulation
}
