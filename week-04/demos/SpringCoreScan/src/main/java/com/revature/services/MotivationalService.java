package com.revature.services;

import org.springframework.stereotype.Service;

// This marks the class as a Spring Bean and we can specify a name if we want but we don't have to
@Service("motivationalServiceBean")
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
