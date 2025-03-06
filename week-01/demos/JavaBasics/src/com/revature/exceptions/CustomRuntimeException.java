package com.revature.exceptions;

public class CustomRuntimeException extends RuntimeException{

    // By extending RuntimeException specifically this creates an UNCHECKED exception which does not necessarily need
    // a try catch block

    public CustomRuntimeException(String message){
        super(message);
    }
}
