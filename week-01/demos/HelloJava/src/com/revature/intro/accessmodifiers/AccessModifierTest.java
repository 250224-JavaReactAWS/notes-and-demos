package com.revature.intro.accessmodifiers;

public class AccessModifierTest {

    public static void main(String[] args){
        // let's see what is visible from this class
        Sample sample = new Sample();

        sample.A = "test";
        sample.B = "test";
        sample.C = "Test";
        // sample.D = "Test";
        // This last line doesn't work because it's not within the Sample class (D is private)
    }
}
