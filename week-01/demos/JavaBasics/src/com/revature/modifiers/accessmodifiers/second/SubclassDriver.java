package com.revature.modifiers.accessmodifiers.second;

import com.revature.modifiers.accessmodifiers.first.Sample;

public class SubclassDriver extends Sample {

    // This class is a subclass of Sample OUTSIDE the original package so it should have access to A and B but not
    // C and D

    // This class is a subclass of Sample so we can access instance variables here


    public static void main(String[] args){
        SubclassDriver sample = new SubclassDriver();
        sample.A = "First";
        sample.B = "Second";
//        sample.C = "Third";
//        sample.D = "Fourth";
        // C is not visible because we're not in the same package
        // D is not visible because we're not in the Sample class

    }
}
