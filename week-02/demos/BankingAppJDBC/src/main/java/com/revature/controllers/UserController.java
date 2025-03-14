package com.revature.controllers;

import com.revature.dtos.response.ErrorMessage;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.services.UserService;
import io.javalin.http.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserController {

    // The controller layer is directly in charge of our Web Traffic
    // Take in incoming request -> Service Layer as needed -> Format the response

    // Javalin methods for this take in the Context object and all return void

    // Logging is good for printing out information to the console and to files to be viewed later
    private final Logger logger = LoggerFactory.getLogger(UserController.class);

    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }

    // TODO Register a new user
    public void registerUserHandler(Context ctx){
        // This method will be called whenever a user need to be created

        // Take in the user object
        User requestUser = ctx.bodyAsClass(User.class);
        // Attempt to read the JSON into this class

        // Validate the username, Validate the password and check for username availability
        if (!userService.validateUsername(requestUser.getUsername())){
            // This means the password is invalid so we need to return a bad request and stop executing
            ctx.status(400);
            ctx.json(new ErrorMessage("Username is not valid. It must be at least 8 characters"));
            return;
        }

        if (!userService.validatePassword(requestUser.getPassword())){
            // This means the password is invalid so we need to return a bad request and stop executing
            ctx.status(400);
            ctx.json(new ErrorMessage("Password is not valid. It must be at least 8 characters and contain a capital " +
                    "and lowercase letter"));
            return;
        }
        if (!userService.isUsernameAvailable(requestUser.getUsername())){
            // This means the password is invalid so we need to return a bad request and stop executing
            ctx.status(400);
            ctx.json(new ErrorMessage("Username is not available, please select a new one"));

            // Log a warning for a user attempting to register with a taken name
            logger.warn("Register attempt made for taken username: " + requestUser.getUsername());
            return;
        }

        // Register the user and log them in
        User registeredUser = userService.registerNewUser(
                requestUser.getFirstName(),
                requestUser.getLastName(),
                requestUser.getUsername(),
                requestUser.getPassword());

        // If something fails we'll report a server side error
        if (registeredUser == null){
            ctx.status(500);
            ctx.json(new ErrorMessage("Something went wrong!"));
            return;
        }

        logger.info("New user registered with username: " + registeredUser.getUsername());

        ctx.status(201);
        ctx.json(registeredUser);

    }

    // TODO Login an existing user
    public void loginHandler(Context ctx){
        // Get the user from the body
        User requestUser = ctx.bodyAsClass(User.class);
        // Attempt to login
        User returnedUser = userService.loginUser(requestUser.getUsername(), requestUser.getPassword());

        // If invalid let them know username or password incorrect
        if (returnedUser == null){
            ctx.json(new ErrorMessage("Username or Password Incorrect"));
            ctx.status(400);
            return;
        }
        // If valid return the user and add them to the session
        ctx.status(200);
        ctx.json(returnedUser);

        // Add the userId to the session
        ctx.sessionAttribute("userId", returnedUser.getUserId());
        ctx.sessionAttribute("role", returnedUser.getRole());
    }

    // TODO (Admin Only) View All Users
    public void getAllUsersHandler(Context ctx){
        // Validate the user is logged in
        if(ctx.sessionAttribute("userId") == null){
            // This means the user is NOT logged in
            ctx.status(401); // UNAUTHORIZED -> Unauthenticated -> We don't know who you are
            ctx.json(new ErrorMessage("You must be logged in to view this method!"));
            return;
        }

        // Validate the logged in user is an admin
        if (ctx.sessionAttribute("role") != Role.ADMIN){
            // The user is logged in but they shouldn't be able to access this since they're not an admin
            ctx.status(403); // FORBIDDEN -> We know who you are but you do not have access to this resource
            ctx.json(new ErrorMessage("You must be an admin to access this endpoint!"));
            return;
        }

        // If admin show the users
        ctx.json(userService.getAllUsers());
    }
}
