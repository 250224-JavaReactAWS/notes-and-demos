package com.revature;

import com.revature.controllers.UserController;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import com.revature.repos.UserDAOImpl;
import com.revature.services.UserService;
import com.revature.util.ConnectionUtil;

import java.sql.Connection;
import java.util.Scanner;

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

        // Let's quickly try to get a connection to test things
        Connection conn = ConnectionUtil.getConnection();



        // Define some variables and make instances of our controllers, services and daos
        UserDAO userDAO = new UserDAOImpl();
        UserService userService = new UserService(userDAO);
        Scanner scan = new Scanner(System.in);

        UserController userController = new UserController(userService, scan);

        // Here's we'll do some simple menu logic to allow the user to interact with the application
        // Login, register and view all users

        boolean running = true;
        // I want to keep track of who is logged in
        User loggedInUser = null;

        while (running){
            if (loggedInUser == null){
                // Sign in or register

                System.out.println("Welcome to our banking application! Please press 1 to register, press 2 to login " +
                        "or press q to quit");

                String input = scan.nextLine();

                // If the input is not a q, 1, or 2 it is invalid so we need a new input
                // An input is valid if it is q OR 1 OR 2
                while(!(input.equals("q") || input.equals("1") || input.equals("2"))){
                    System.out.println("Invalid input. Please enter a new value: ");
                    input = scan.nextLine();
                }

                if (input.equals("1")){
                    // Register Logic
//                    System.out.println("Register");
                    loggedInUser = userController.registerNewUser();

                } else if (input.equals("2")){
                    // Login logic
//                    System.out.println("Login");
                    loggedInUser = userController.loginUser();

                } else if (input.equals("q")){
                    System.out.println("Quitting application!");
                    break; // Cancels out of the while loop and allows the program to end
                }


            } else {
                // This means we're logged in so we'll have application logic here
                // There isn't a lot of logic we can do right now. Here the Customers cannot do anything but the
                // admin should be able to view all users
                if (loggedInUser.getRole() == Role.CUSTOMER){
                    System.out.println("Thanks for signing in, there is no current Customer functionality. Logging out!");
                    loggedInUser = null;
                } else{
                    // Logged in user is an Admin
                    System.out.println("Please enter a choice. Press 1 to view all users or q to logout");

                    String choice = scan.nextLine();

                    while (!(choice.equals("1") || choice.equals("q"))){
                        System.out.println("Invalid choice, please enter a new choice");
                        choice = scan.nextLine();
                    }

                    // View all users or logout

                    if (choice.equals("1")){
                        // View all users logic
                        userController.getAllUsersHandler();
                    } else{
                        loggedInUser = null;
                    }
                }
            }
        }
    }
}