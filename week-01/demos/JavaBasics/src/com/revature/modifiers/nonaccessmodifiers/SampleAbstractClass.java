package com.revature.modifiers.nonaccessmodifiers;

public abstract class SampleAbstractClass {

    /*
    This class has been marked as ABSTRACT this means it can contain methods that are also abstract or regular methods
     */

    public void regularMethod(){
        System.out.println("This is a normal method with a method body");
    }

    // Methods marked with the abstract keyword do NOT have a method body
    public abstract void abstractMethod();
}
