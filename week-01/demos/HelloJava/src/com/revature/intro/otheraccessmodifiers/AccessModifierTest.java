package com.revature.intro.otheraccessmodifiers;

import com.revature.intro.accessmodifiers.Sample;

public class AccessModifierTest {

    public static void main(String[] args){
        // Let's make a sample object
        Sample sample = new Sample();
        // Notice how we had to import the class in at the top, this is because it belongs to a different package

        sample.A = "test";
        // sample.B = "test";
        // sample.C = "test";
        // sample.D = "test";
        // None of these variables are accessible since we are in a different package and this is NOT a sublclass
        // D is private -> Only visible within Sample
        // C is default -> Only visible within the same package
        // B is protected -> Visible in the same package AND all subclasses
    }
}
