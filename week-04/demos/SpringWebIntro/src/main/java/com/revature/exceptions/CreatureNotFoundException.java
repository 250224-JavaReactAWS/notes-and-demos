package com.revature.exceptions;

public class CreatureNotFoundException extends RuntimeException{

    public CreatureNotFoundException(String message) {
        super(message);
    }
}
