package com.revature.modifiers.accessmodifiers.second;

import com.revature.modifiers.accessmodifiers.first.Sample;

public class Driver {

    public static void main(String[] args){
        Sample sample = new Sample();

        // Let's see which variables are accessible
        sample.A = "First";
//        sample.B = "Second";
//        sample.C = "Third";
//        sample.D = "Fourth";

        // A is the only accessible variable here since the package is different and this is NOT a subclass of sample
    }
}
