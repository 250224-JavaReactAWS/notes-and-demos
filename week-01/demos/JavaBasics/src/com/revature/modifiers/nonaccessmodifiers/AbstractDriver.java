package com.revature.modifiers.nonaccessmodifiers;

public class AbstractDriver {

    public static void main(String[] args){
        // We cannot create direct instances of abstract classes
        // Abstract classes cannot be instantiated

//        SampleAbstractClass sac = new SampleAbstractClass();
        SampleAbstractClass sac = new SampleImplementingClass();

        sac.regularMethod();
        sac.abstractMethod();
    }
}
