package com.revature;

import io.javalin.Javalin;

import java.util.ArrayList;
import java.util.List;

public class HelloWorld {
    /*
    Javalin is a simple web framework that allows us to set up a Java server with just a few lines of code.

    The process is relatively simple, you need to define your route and functions but besides that it's pretty easy to
    set up. All of you handlers will take in a Context object which is a representation of both the HTTP Request and
    Response allowing you to manipulate the response from all of details available in the request

    To get started with Javalin we need the Javalin dependency as well as a logger
    Logger -> A framework that allows us to create nicely constructed print messages with various levels of detail
    and allows us to append them to different locations

    To get started we're going to add SLF4J and Logback.
    SLF4J (Simple Logging Facade 4 Java)-> A specification about using general logging frameworks. It outlines different
     methods that a logging framework should have and it will implemented by various different logging frameworks. This
     allows you swap between different loggers without changing the code (think of it like an interface).

    Logback -> Actual logging framework. This is an IMPLEMENTATION of SLF4J and allows us to write various logs to both
    the console as well as different files. Logs typically include time/date as well as thread information and calling
    classes as well as LOGGING LEVELS. Logging levels are a way to control how much or how detailed print information you
    want.
    TRACE > DEBUG > INFO > WARN > ERROR
    Trace
        - Super granular information that incorporates every detail of your application. Full visibility
    Debug
        - Less granular info but more everyday stuff you'd need to debug the application
    Info
        - General logging level, used to denote any standard thing that might be happening
    Warn
        - Highlights code that could potentially be a problem
    Error
        - Used when critical components of the application are not functioning

     */


    public static void main(String[] args) {
        // This code is creating a Java Server with the following properties
        // It's listening on port 7070 -> This means the path to the API will start with http://localhost:7070/
        // This is creating a simple get request that allows us to get a Hello World message when we send a GET request
        var app = Javalin.create(/*config*/)
                // This .get allows for us to send a GET request to http://localhost:7070
                .get("/", ctx -> ctx.result("Hello from our Java Application"))
                // Now we have a request for http://localhost:7070/message
                .get("/message", ctx -> ctx.result("This is a simple message!"))

                // Path Variables and Query Parameters
                // A Path variable is a variable that exists in the URL so we can grab it and do some operation with it
                // http://localhost:7070/number/17
                .get("/number/{num}", ctx -> {
                    // This can be expanded to contain a nice multiline function where I get information from the
                    // Request
                    // The Context object represents the HTTP Request and Response
                    int num = Integer.parseInt(ctx.pathParam("num"));

                    if (num % 2 == 0){
                        ctx.result("The number " + num + " is even!");
                    } else {
                        ctx.result("The number " + num + " is odd!");
                    }
                })
                // One other option we have for the URL is a query param (sometimes also called a request param) basically
                // this is used to filter based off key value pairs

                // http://localhost:7070/people?key=value&key2=value2
                .get("/people", ctx -> {
                    // Let's create a list of people
                    List<String> names = new ArrayList<>();

                    names.add("Adam");
                    names.add("Ashley");
                    names.add("Bryan");
                    names.add("Ben");
                    names.add("Bethany");
                    names.add("Charlie");

                    // Query params are typically used for filtering
                    String nameStartsWith = ctx.queryParam("starts");
                    // http://localhost:7070/people?starts=a
                    // This should return all people whose name begins with a
                    if (nameStartsWith == null){
                        ctx.result(names.toString());
                    } else {
                        List<String> filteredNames = new ArrayList<>();

                        for (String name: names){
                            if (name.startsWith(nameStartsWith)){
                                filteredNames.add(name);
                            }
                        }

                        ctx.result(filteredNames.toString());
                    }


                })


                .start(7070);
    }
}