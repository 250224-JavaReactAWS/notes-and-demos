package com.revature.modifiers.nonaccessmodifiers;

public class SampleImplementingClass extends SampleAbstractClass{
    @Override
    public void abstractMethod() {
        // In SampleAbstractClass, this method DOES NOT have a method body since it was marked as abstract
        // We need to provide a method body so whenever we call this method it'll actually work

        System.out.println("Method body declared in child implementing class");
    }
}
