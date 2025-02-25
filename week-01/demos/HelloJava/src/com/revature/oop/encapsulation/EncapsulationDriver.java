package com.revature.oop.encapsulation;

public class EncapsulationDriver {
    /*
    Encapsulation is a pillar of OOP focused on protecting our data from unwanted manipulation

    HOW:
        Prevent direct manipulation/access to instance variables (we will mark all variables as private)
        Since we still need to be able to read the field and update it we'll create custom methods for those
        operations
    WHY:
    Modification without safety can lead to inconsistencies in the data
     */

    public static void main(String[] args){
        User sampleUser = new User("JohnSmith", "Password1234", 27);

        // Before we encapsulate this class the data is vulnerable to bad updates
//        sampleUser.age = -1; // This number should be positive
        // Username should have at least 10 characters and no spaces
//        sampleUser.username = "Bad user";
        // Password needs a Capital letter, lowercase letter and a number
//        sampleUser.password = "password";

        // Retreive the age of the sample user
        System.out.println(sampleUser.getAge());
        // Attempt to update the data
        sampleUser.setAge(-30); // Because we encapsulate our age field it is protected from the bad update
        System.out.println(sampleUser.getAge());

        System.out.println(sampleUser.getUsername());
        sampleUser.setUsername("Bad User");
        System.out.println(sampleUser.getUsername());
        // We're protected from the bad update because we encapsulated the username field
    }
}
