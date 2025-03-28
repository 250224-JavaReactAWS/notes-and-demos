package com.revature.services;

import com.revature.exceptions.EmailAlreadyTakenException;
import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repos.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserDAO userDAO;

    @Autowired
    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    // TODO Register
    public User register(User userToBeRegistered){
        // I need to verify there isn't a user with the specified username
        Optional<User> potentialUser = userDAO.findUserByEmail(userToBeRegistered.getEmail());

        if (potentialUser.isPresent()){
            throw new EmailAlreadyTakenException("Email: " + userToBeRegistered.getEmail() + " is already taken!");
        }

        // other validation can be done for the email/password

        // Attempt to register the user
        userToBeRegistered.setRole(Role.STUDENT);
        return userDAO.save(userToBeRegistered);
    }

    // TODO Login
    public Optional<User> login(User userCredentials){

        // Look up the user by their username;
        Optional<User> potentialUser = userDAO.findUserByEmail(userCredentials.getEmail());

        // Validate the password match if the user is present
        if (potentialUser.isPresent()){
            User returnedUser = potentialUser.get();

            // Verify the user password matches
            if (returnedUser.getPassword().equals(userCredentials.getPassword())){
                return potentialUser;
            }
        }

        return Optional.empty();

    }


}
