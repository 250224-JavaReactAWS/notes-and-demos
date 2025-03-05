package com.revature.controllers;

import com.revature.models.User;
import com.revature.services.UserService;

import java.util.List;
import java.util.Scanner;

public class UserController {

    /*
    Typically this class is in charge of web traffic but today it will be in charge of display logic

    This class will call upon different methods in the service layer to be used to create a user
    / login a user / get all users
     */

    private UserService userService;

    private Scanner scan;

    public UserController(UserService userService, Scanner scan){
        this.userService = userService;
        this.scan = scan;
    }

    // TODO Get All Users
    public void getAllUsersHandler(){
        // Prints all users in the system

        List<User> allUsers = userService.getAllUsers();

        System.out.println("All Users: ");
        for (User u: allUsers){
            System.out.println(u);
        }
    }

    // TODO Register a New User
    public User registerNewUser(){
        // Take in user information for the account
        // First name
        System.out.println("What is your first name?");
        String firstName = scan.nextLine();
        // Last name
        System.out.println("What is your last name?");
        String lastName = scan.nextLine();
        // Username
        System.out.println("Enter a Username: ");
        String username = scan.nextLine();

        // Validate the username fits our security metrics
        // TODO tweak logic as needed
        while (!userService.validateUsername(username) || !userService.isUsernameAvailable(username)){
            if (!userService.validateUsername(username)){
                System.out.println("Username must be at least 8 characters! Please enter a new Username: ");
                username = scan.nextLine();
            } else {
                System.out.println("Username is already taken! Please enter a new Username: ");
                username = scan.nextLine();
            }
        }

        // Password
        System.out.println("Enter a password: ");
        String password = scan.nextLine();

        while (!userService.validatePassword(password)){
            System.out.println("Password must contain an Uppercase letter, lowercase letter and must be at least 8 characters");
            System.out.println("Please enter a new password: ");
            password = scan.nextLine();
        }

        // At this point the username and passwords should valid and available
        return userService.registerNewUser(firstName, lastName, username, password);
    }

    // TODO Login a User
    public User loginUser(){
        // Take in a username
        System.out.println("Please enter a username:");
        String username = scan.nextLine();
        // Take in a password
        System.out.println("Please enter a password:");
        String password = scan.nextLine();

        // Attempt to login the user
        User returnUser = userService.loginUser(username, password);
        if (returnUser == null){
            System.out.println("Username or password incorrect!");
            return null;
        }

        System.out.println("Welcome back " + returnUser.getFirstName() +" " + returnUser.getLastName()+ "!");
        return returnUser;

    }
}
