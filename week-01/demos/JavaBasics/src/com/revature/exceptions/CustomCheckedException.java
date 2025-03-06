package com.revature.exceptions;

public class CustomCheckedException extends Exception{
    // To Create a custom CHECKED exception create an regular class and extend the Exception class

    // One common thing to do is allow for a message to be passed to provide the end user with some information as
    // to what went wrong

    public CustomCheckedException(String message){
        // Pass this to the Exception class constructor
        super(message);
    }
}
