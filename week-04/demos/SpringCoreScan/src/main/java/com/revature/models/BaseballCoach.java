package com.revature.models;

import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component("baseballCoachBean") // This marks the class as a Spring Bean and it needs to be managed
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
    @Autowired // This allows Spring to do automatic configuration for the dependencies (provide they are beans)
                // Usually this works by type first but you can specify things if needed
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
