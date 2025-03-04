package com.revature.modifiers.nonaccessmodifiers;

public class ExtendingClass {

    // This class CANNOT inherit from the final class FinalClass since it was marked with final

    // Final variables
    // They need to be assigned a value and that value cannot be reassigned

    private final String name;

    // We need to initialize the variable with the constructor
    public ExtendingClass(String name){
        this.name=name;
    }

    // Getters
    public String getName(){
        return this.name;
    }

    // Let's try to add a setter
    public void setName(String name){
//        this.name = name;
        // This setter will not work because we can never change the value of a final variable
    }


    // Let's create a final method
    // Final methods do get inherited, but cannot be overridden
    public final void cannotOverride(){
        System.out.println("This method cannot be overridden");
    }

    public final void cannotOverride(String message){
        System.out.println("message");
    }
}
