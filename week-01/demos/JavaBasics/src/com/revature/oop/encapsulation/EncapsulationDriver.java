package com.revature.oop.encapsulation;

public class EncapsulationDriver {

    /*
    Our third pillar of OOP is encapsulation which works as a shield for our object's data to prevent them from
    being updated in unintended ways.

    Age -> Age should always be positive, so we shouldn't be able to set it to a negative number
    Email -> Emails should not be able to be set to a non-email
    Password -> Passwords can have a lot of requirements, let's say it must be at least 8 characters long
     */

    public static void main(String[] args){
        // BEFORE ENCAPSULATION
        // Be we encapsulate we can set/update variables to whatever we want directly

        Employee e1 = new Employee();
//        e1.age = -12;
//        e1.email = "not_an_email";
//        e1.password = "short";

        // Since we can DIRECTLY access the fields we can't control how the data will be updated
        // To prevent this we'll stop their access entirely

        // Now that the fields are private I cannot access them at all
        // But what if I need to update them or view their values
//        System.out.println(e1.email);
        // We need to create something that allows us to get the information from the fields and update them properly
//        System.out.println(e1.getEmail());

        e1.setAge(13);
        System.out.println(e1.getAge());
        e1.setAge(-12);
        System.out.println(e1.getAge());

        e1.setEmail("test@example.com");
        System.out.println(e1.getEmail());
        e1.setEmail("not_an_email");
        System.out.println(e1.getEmail());

        e1.setPassword("GoodPassword");
        System.out.println(e1.getPassword());
        e1.setPassword("short");
        System.out.println(e1.getPassword());
    }
}
