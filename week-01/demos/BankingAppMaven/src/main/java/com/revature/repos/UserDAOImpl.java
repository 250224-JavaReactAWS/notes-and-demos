package com.revature.repos;

import com.revature.models.Role;
import com.revature.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{

    /*
    Normally this class would be making requests to a SQL database but we're not there yet so we're going
    to use a master list that will allow us to add users, get users, etc
     */

    private List<User> allUsers;

    public UserDAOImpl(){
        allUsers = new ArrayList<>();
        // We'll add in a few default users that will always exist when the application get restarted
        User customer1 = new User("Bryan", "Serfozo", "bserfozo", "Password");
        User customer2 = new User("Terra", "Dactyl", "terradactyl", "Password");
        User admin = new User("Admin", "User", "adminuser", "Password123!");
        // Update the admin's role
        admin.setRole(Role.ADMIN);
        // Save all of the users to the list
        allUsers.add(customer1);
        allUsers.add(customer2);
        allUsers.add(admin);

    }

    @Override
    public User getUserByUsername(String username) {

        for (User u: allUsers){
            if (u.getUsername().equals(username)){
                return u;
            }
        }

        return null;
    }

    @Override
    public User create(User obj) {
        // This basically amounts to adding the user to the list
        allUsers.add(obj);
        return obj;
    }

    @Override
    public List<User> getAll() {
        return allUsers;
    }

    @Override
    public User getById(int id) {
        // To get a user by the user's id we'll need to loop through the users and get the user that has a specific id

        User returnedUser = null;

        // Iterate through the list to find the right user
        for (User u: allUsers){
            if (u.getUserId() == id){
                returnedUser = u;
                break;
            }
        }

        return returnedUser;
    }

    @Override
    public User update(User obj) {
        // Let's look through the "database" for the user by its id
        // Update every field as needed
        for (User u: allUsers){
            if(u.getUserId() == obj.getUserId()){
                // We are updating the same object if we are in here
                u.setFirstName(obj.getFirstName());
                u.setLastName(obj.getLastName());
                u.setUsername(obj.getUsername());
                u.setPassword(obj.getPassword());
                u.setRole(obj.getRole());
            }
        }

        return obj;
    }

    @Override
    public boolean deleteById(int id) {
        // Filter to find the right User
        for (User u: allUsers){
            if (u.getUserId() == id){
                return allUsers.remove(u);
            }
        }
        // We only get here if we cannot find the user
        return false;
    }
}
