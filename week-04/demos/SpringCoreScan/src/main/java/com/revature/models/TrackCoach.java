package com.revature.models;

import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("trackCoachBean")
public class TrackCoach implements Coach{

    // Let's set up our constructor injection
    private final MotivationalService motivationalService;

    private final WorkoutService workoutService;

    @Autowired
    public TrackCoach(MotivationalService motivationalService, WorkoutService workoutService) {
        System.out.println("Track Coach initialized");
        this.motivationalService = motivationalService;
        this.workoutService = workoutService;
    }


    @Override
    public String getDailyWorkout() {
        return workoutService.fetchWorkoutRoutine("track");
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
