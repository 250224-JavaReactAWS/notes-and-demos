package com.revature.models;

import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;

public class BasketballCoach implements Coach{
    /*
    For our other coaches we set up the dependencies through constructor injection (injecting via the constructor)

    Sometimes this doesn't work. For example if Class A depends on Class B AND Class B depends on Class A, how do you
    create each object. This is called a circular dependency.

    The way to solve this is through Setter Injection. Setter injection creates the object the first and then sets
    the other beans through a setter method
     */

    private String email;

    private String teamName;

    private MotivationalService motivationalService;

    private WorkoutService workoutService;


    public BasketballCoach(){
        System.out.println("Basketball Coach Initialized");
    }

    // SETTERS
    public void setMotivationalService(MotivationalService motivationalService) {
        this.motivationalService = motivationalService;
    }

    public void setWorkoutService(WorkoutService workoutService) {
        this.workoutService = workoutService;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("basketball");
    }

    @Override
    public String getMotivation() {
        return motivationalService.fetchMotivationalQuote();
    }

    @Override
    public MotivationalService getMotivationalService() {
        return motivationalService;
    }

    @Override
    public WorkoutService getWorkoutService() {
        return workoutService;
    }
}
