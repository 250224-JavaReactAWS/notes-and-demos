package com.revature.services;

public class WorkoutService {

    /*
    This service class we'll pretend is making an API call to some sort of workout API and it will get us information
    based off the sport the athlete is doing
     */

    public WorkoutService(){
        System.out.println("Workout Service Initialized!");
    }

    public String fetchWorkoutRoutine(String coachType){
        switch (coachType.toLowerCase()){
            case "baseball":
                return "Today's Workout: Spend an hour at batting practice";
            case "track":
                return "Today's Workout: Run a 5k in 30 minutes";
            case "basketball":
                return "Today's Workout: Free throw practice for half an hour";
            default:
                return "No workout today, enjoy your rest day!";
        }
    }
}
