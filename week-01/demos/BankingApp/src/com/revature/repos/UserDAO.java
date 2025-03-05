package com.revature.repos;

import com.revature.models.User;

import java.util.List;

public interface UserDAO extends GeneralDAO<User>{

    /*
    This is called a DAO interface. DAO stands for Data Access Object. This will be in charge of directly
    interfacing with the data no matter where it is stored. Why are we starting as an interface? We can
    have multiple implementations for this DAO interface that interact with different locations of data.
    We may have one implementation that works with a CSV file, maybe one that works with an internal list, or
    we could have one that works with a SQL database.


    Here we will define all of the ways we want to interface with our data
    CRUD Methods
    CREATE
        - Creating a new user
    READ
        - Reading all users
        - Reading a user by Id
    UPDATE
        - Updating a user
    DELETE
        - Deleting a user by Id
     */

    // The below methods were extracted to the GeneralDAO

//    User createUser(User user);
//
//    List<User> getAllUsers();
//
//    User getUserById(int userId);
//
//    User updateUser(User user);
//
//    boolean deleteUserById(int userId);

    // When we try to login or register we need to get a user by their username to validate info
    User getUserByUsername(String username);
}
