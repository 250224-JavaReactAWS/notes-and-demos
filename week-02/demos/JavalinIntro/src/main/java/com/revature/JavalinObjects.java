package com.revature;

import io.javalin.Javalin;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JavalinObjects {

    public static void main(String[] args) {
        // Let's create a couple of sample users
        List<User> allUsers = new ArrayList<>();

        allUsers.add(new User(1, "Linda Johnson", "linda", "password"));
        allUsers.add(new User(2, "Ricky Bobby", "ricky", "password"));
        allUsers.add(new User(3, "Jean Girard", "jean", "password"));


        // What is var?
        // This was introduced in Java 10 and it's used to implicitly infer the type of variable from the function
        var app = Javalin.create()
                // Let's start talking about Objects and taking those in for more complex requests
                // Maybe we want to log a user in
                // Typically logging in a user is a POST request. Why? because we are establishing a connection with
                // server, changing state and we have to pass in a request body
                .post("/login", ctx -> {
                    // We need to extract a user object from the Request Body
                    User requestUser = ctx.bodyAsClass(User.class);
                    // It is important to note that this object will be deserialized from JSON
                    // JSON -> JavaScript Object Notation -> How objects are written (as a string) in JavaScript
                    // JSON is currently the most common DATA EXCHANGE FORMAT
                    // This will be a string that looks something "{ "key":"value" }"
                    // Serialized -> Take a java object and turn it into a JSON String
                    // Deserialized -> Take a JSON string and turn it into a Java Object
                    // There are libraries for this and we will use Jackson Databind


                    // We're expecting them to have a username and a password, let's try to "Log them in"
                    for (User u: allUsers){
                        if (u.getUsername().equals(requestUser.getUsername())){
                            if (u.getPassword().equals(requestUser.getPassword())){
                                // Inside of here the credentials are verified and we can return the user

                                // I'll turn the Java Object back into JSON and send it as the response body
                                ctx.json(u);
                                ctx.status(200); // 200 is the default

                                // One way to keep track of the logged in user after authentication is by using Sessions
                                // A Session is a server-tracked object that represents specific information that
                                // is useful for determining information about a user.

                                // Typically we can set whatever values we want inside of it and we can retrieve those
                                // values later
                                ctx.sessionAttribute("userId", u.getUserId());

                                return;
                            }
                        }
                    }

                    // In the event the login information is wrong we should let the client know
                    // The easiest way to do this is with the status code
                    // Maybe we'll also do an error message object
                    ctx.status(400); // BAD REQUEST -> bad credentials
                    ctx.json(new ErrorMessage("Username or Password Incorrect"));

                })
                .get("dashboard", ctx -> {
                    // I will get the value from the current session
                    int userId = ctx.sessionAttribute("userId");

                    // Not logged in
                    if (userId <= 0){
                        ctx.status(401);
                        ctx.json(new ErrorMessage("You must be logged in to view this feature!"));
                    }

                    // Return user info if logged in
                    for(User u: allUsers){
                        if (u.getUserId() == userId){
                            ctx.json(u);
                            return;
                        }
                    }
                })

                .start(7070);
    }
}

class User {
    private int userId;
    private String name;
    private String username;
    private String password;

    public User(int userId, String name, String username, String password) {
        this.userId = userId;
        this.name = name;
        this.username = username;
        this.password = password;
    }

    public User() {
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

class ErrorMessage{
    private Date timestamp;
    private String message;

    public ErrorMessage(String message) {
        this.timestamp = new Date();
        this.message = message;
    }

    public ErrorMessage() {
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
