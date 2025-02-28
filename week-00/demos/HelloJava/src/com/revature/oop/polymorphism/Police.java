package com.revature.oop.polymorphism;

public class Police extends FirstResponder{

    // A Police Officer is a type of first responder whose job it is to stop crime and arrest criminals
    // so when call saveTheDay it should say that they're stopping crime and arresting criminals


    // In this child class I want to OVERRIDE the functionality from the parent class, basically giving new
    // functionality to the same method

    // We mark this with @Override to denote to the compiler that the method comes from a super class (FirstResponder)
    @Override
    public void saveTheDay(){
        System.out.println("Stopping crime and catching criminals!");
    }
}
