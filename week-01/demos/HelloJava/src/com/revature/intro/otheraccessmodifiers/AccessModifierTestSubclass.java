package com.revature.intro.otheraccessmodifiers;

import com.revature.intro.accessmodifiers.Sample;

public class AccessModifierTestSubclass extends Sample {

    // This is a subclass of Sample OUTSIDE of the accessmodifiers package

    public static void main(String[] args){
        Sample sample = new Sample();

        sample.A = "test";
//        sample.B = "test";
//        sample.C = "test";
//        sample.D = "test";


    }

    public void test(){
        this.B = "test";
        // B is accessible but only as an instance variable because it is Protected
    }
}
