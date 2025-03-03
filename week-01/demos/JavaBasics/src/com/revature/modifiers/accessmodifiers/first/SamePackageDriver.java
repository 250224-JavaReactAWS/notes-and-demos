package com.revature.modifiers.accessmodifiers.first;

public class SamePackageDriver {

    // This class should have access to variables A, B, C but NOT D

    public static void main(String[] args){
        Sample sample = new Sample();
        sample.A = "First";
        sample.B = "Second";
        sample.C = "Third";
//        sample.D = "Fourth";
        // D is only accessible with the same class
    }
}
