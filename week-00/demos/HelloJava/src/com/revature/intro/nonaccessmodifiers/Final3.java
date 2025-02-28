package com.revature.intro.nonaccessmodifiers;

public class Final3 {
    // This class cannot inherit from Final2 because Final2 is a final class

    // Final variable
    // Final variables need to be initialized with a value and then cannot be changed
    final int cannotChange;

    public Final3(int cannotChange){
        this.cannotChange = cannotChange;
    }
}
