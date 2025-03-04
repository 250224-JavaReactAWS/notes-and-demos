package com.revature.modifiers.nonaccessmodifiers;

public class SecondExtendingClass extends ExtendingClass{

    // Constructor required to pass info to the parent class
    public SecondExtendingClass(String name) {
        super(name);
    }

    // Let's try to override the method from ExtendingClass
//    @Override
//    public void cannotOverride(){
//
//    }

    // This does not work since the method is marked as final

    // I could make another method that technically overloads the other methods
    public final void cannotOverride(String name, String name2){

    }
}
