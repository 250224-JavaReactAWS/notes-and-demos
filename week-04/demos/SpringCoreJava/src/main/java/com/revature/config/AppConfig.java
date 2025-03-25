package com.revature.config;

import com.revature.models.BaseballCoach;
import com.revature.models.BasketballCoach;
import com.revature.models.TrackCoach;
import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration // This annotation marks this class as a configuration class
public class AppConfig {
    /*
    This file will contain configuration details for working with our Spring Beans. We want to start leveraging this
    so we can move away from XML based configuration (since it's old and bloated). Notice this will start to become a
    little annotation heavy. This class will be a direct alternative to the XML config

    Inside of this class we'll create our beans as the methods of this class
     */

    // <bean id="motivationalServiceBean" class="com.revature.services.MotivationalService" />

    @Bean // This lets the compiler know this will be a Spring Bean. The default name is the name of the method
    public MotivationalService motivationalServiceBean(){
        // This method can be used to configure the bean and construct it as needed
        return new MotivationalService();
    }

    // Let's try to create the workout service too
    @Bean("workoutServiceBean") // Providing a name here overrides the default (method name)
    @Scope("prototype") // The changes the scope to prototype and allows us to create a new object every time
    public WorkoutService workoutService(){
        return new WorkoutService();
    }

    // Let's create our Baseball coach

    @Bean
    public BaseballCoach baseballCoachBean(){
        return new BaseballCoach(motivationalServiceBean(), workoutService());
    }

    @Bean
    public TrackCoach trackCoachBean(){
        return new TrackCoach(motivationalServiceBean(), workoutService());
    }

    //Basketball Coach uses SETTER INJECTION
    @Bean
    public BasketballCoach basketballCoachBean(){

        // Create a BasketballCoach
        BasketballCoach basketballCoach = new BasketballCoach();
        // Set the fields as needed
        basketballCoach.setWorkoutService(workoutService()); // Prototype so a new one should be made
        basketballCoach.setMotivationalService(motivationalServiceBean());

        // Set normal values just like usual
        basketballCoach.setEmail("lebron.james@nba.com");
        basketballCoach.setTeamName("Lakers");

        // Return the bean
        return basketballCoach;
    }

}
