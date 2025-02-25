package com.revature.intro.nonaccessmodifiers;

public class Final1 {

    // This is our first class and it will contain a final method

    public final void cantBeOverridden(){
        System.out.println("This method cannot be changed in a child class");
    }

    public void canBeOverridden(){

    }
}
