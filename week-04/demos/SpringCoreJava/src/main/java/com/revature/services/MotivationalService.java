package com.revature.services;

public class MotivationalService {

    /*
    This class is a service class that we'll pretend is making an API call and returning some sort of motivational
    quote. This quote will be used by our "coaches" as they coach their athletes
     */

    public MotivationalService(){
        // This is only here for visibility
        System.out.println("Motivational Service Initialized");
    }

    public String fetchMotivationalQuote(){
        // Let's use a stars war quote
        return "Do or do not, there is no try";
    }
}
