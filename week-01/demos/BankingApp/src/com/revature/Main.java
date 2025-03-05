package com.revature;

public class Main {
    /*
    Today we're going to get started building out a simple banking application. It will have a couple
    basic features such as registering, logging in, creating an account, viewing all accounts, depositing/
    withdrawing/transferring for those accounts.

    Application has 3 major layers and a model layer
    Models
        - Define what the data looks like
    Repo/DAO Layer
        - In charge of directly interfacing with the data
    Service Layer
        - In charge of any business logic
    Controller Layer
        - This will be in charge of display logic (typically this layer handles web traffic)

    This main class is in charge of starting and running the application so we'll hold some menu logic here
    and allow a user to interface with the application from here
     */

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}