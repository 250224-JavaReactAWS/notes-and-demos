package com.revature.models;

import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;

public interface Coach {

    // This will have all of the shared methods between our coaches

    String getDailyWorkout();

    String getMotivation();

    // We're going to add some getters for visibility
    MotivationalService getMotivationalService();

    WorkoutService getWorkoutService();
}
