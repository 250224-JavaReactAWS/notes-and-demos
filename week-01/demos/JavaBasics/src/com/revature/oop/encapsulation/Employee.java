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

    public void setAge(int age){
        // Here we want to properly encapsulate the data in the age field and prevent it from being negative
        if (age > 0){
            this.age = age;
        }
    }

    // Email
    // Every email should contain the @ symbol
    public void setEmail(String email){
        // In the event the incoming string contains an @ symbol we'll update the email, otherwise skip
        if (email.contains("@")){
            this.email = email;
        }
    }

    // Password
    // Length must be at least 8 characters
    public void setPassword(String password){
        if (password.length() >= 8){
            this.password = password;
        }
    }
}
