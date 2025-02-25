package com.revature.oop.encapsulation;

public class User {

    // This class will represent some sort of online user

    private String username;

    private String password;

    private int age;

    // Now that they're private they can only be directly accessed inside of this class

    public User(String username, String password, int age){
        this.username = username;
        this.password = password;
        this.age = age;
    }

    // Methods for updating and retrieving the instance variables
    // Getters and Setters
    // Mutators

    // Getters (Used to read the data)
    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public int getAge(){
        return this.age;
    }

    // To update the variables I use SETTERS
    // In the setter I can provide custom logic to prevent bad updates
    public void setAge(int age){
        // If age is 0 or less, we simply do not update the data
        // Otherwise update the data
        if (age > 0){
            this.age = age;
        }
    }

    public void setUsername(String username){
        if (username.length() >= 10 && !username.contains(" ")){
            this.username = username;
        }
    }

}
