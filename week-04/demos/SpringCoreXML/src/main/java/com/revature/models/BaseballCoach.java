package com.revature.models;

import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;

public class BaseballCoach implements Coach{
    /*
    Recall earlier that we said Dependency Injection is what is done by Spring and it's the process of creating
    loosely-coupled pieces of application code by injecting dependencies from an external source
     */

    // NOT DEPENDENCY INJECTION
    // I created the objects here so I CANNOT inject different ones
    // This is TIGHTLY Coupled
//    MotivationalService motivationalService = new MotivationalService();
//    WorkoutService workoutService = new WorkoutService();


    // THIS IS DEPENDENCY INJECTION
    // I CAN INJECT DIFFERENT DEPENDENCIES AS NEEDED FOR THESE SERVICES
    // This is now loosely coupled
    private final MotivationalService motivationalService;

    private final WorkoutService workoutService;

    // CONSTRUCTOR INJECTION (DEFAULT)
    public BaseballCoach(MotivationalService motivationalService, WorkoutService workoutService) {
        // For visibility let's add a print statement
        System.out.println("Baseball Coach Initialized");

        this.motivationalService = motivationalService;
        this.workoutService = workoutService;
    }

    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("baseball");
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
