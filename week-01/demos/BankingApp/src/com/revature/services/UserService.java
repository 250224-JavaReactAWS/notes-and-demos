package com.revature.services;

import com.revature.models.User;
import com.revature.repos.UserDAO;

import java.util.List;

public class UserService {

    /*
    Service classes are in charge of business logic and validating that everything is working within the application
    Typically this will include methods that will be called by the controller layer to perform certain operations on
    the data

    The methods in this class will align more with the user stories than the DAO layer but we still need the DAO layer
    to interact with the data
     */

    private UserDAO userDAO;

    public UserService(UserDAO userDAO){
        this.userDAO = userDAO;
    }

    // TODO Validate Username Security
    public boolean validateUsername(String username){
        // Any sort of criteria we have for our username can be evaluated here
        // Length >= 8 characters

        return username.length() >= 8;
    }

    // TODO Validate Username availability
    // If a username is already taken we want to return false (the username is not available)
    public boolean isUsernameAvailable(String username){
        return userDAO.getUserByUsername(username) == null;
    }

    // TODO Validate Password Security
    public boolean validatePassword(String password){
        // Length must be at least 8 and contains an uppercase and lowercase letter
        boolean correctLength = password.length() >= 8;
        boolean hasLowercase = false;
        boolean hasUppercase = false;

        // We're going to break apart the string into a character array and then validate that it contains an uppercase
        // and lower case by using the Wrapper Class methods
        char[] characters = password.toCharArray();
        // Loop through the characters
        for (char c: characters){
            // Validate if the character is uppercase or lowercase
            // Wrapper classes like Integer, Double, Character, etc contain static methods that are useful for working
            // with their primitives and also casting
            if (Character.isUpperCase(c)){
                hasUppercase = true;
            } else if (Character.isLowerCase(c)){
                hasLowercase = true;
            }
        }

        return correctLength && hasLowercase && hasUppercase;
        // If you know regex, this can all be done on one line
    }

    // TODO Register
    public User registerNewUser(String firstName, String lastName, String username, String password){
        // NOTE: We expect our validation methods to be called BEFORE this method is called in the controller layer
        // Create a new user object
        User userToBeSaved = new User(firstName, lastName, username, password);

        // Save the user to the "database"
        return userDAO.create(userToBeSaved);

    }

    // TODO Login
    public User loginUser(String username, String password){
        // Get the user by their username
        User returnedUser = userDAO.getUserByUsername(username);
        if (returnedUser == null){
            return null;
        }
        // Validate the password matches
        if (returnedUser.getPassword().equals(password)){
            // Return the user
            return returnedUser;
        }
        return null;

    }

    // TODO Get All Users
    public List<User> getAllUsers(){
        return userDAO.getAll();
    }


}
