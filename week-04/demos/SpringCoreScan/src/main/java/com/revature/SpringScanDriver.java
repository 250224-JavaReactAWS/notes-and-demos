package com.revature;

import com.revature.config.AppConfig;
import com.revature.models.BaseballCoach;
import com.revature.models.BasketballCoach;
import com.revature.models.TrackCoach;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SpringScanDriver {
    public static void main(String[] args) {

        System.out.println("Creating our bean container....");


        try(AnnotationConfigApplicationContext beanContainer = new AnnotationConfigApplicationContext(AppConfig.class)){
            System.out.println("Bean Container Created!");
            System.out.println("-----------------------");


            BaseballCoach baseballCoach = beanContainer.getBean("baseballCoachBean", BaseballCoach.class);

            // Let's check our values
            System.out.println(baseballCoach.getDailyWorkout());
            System.out.println(baseballCoach.getMotivation());

            // Let's get our track coach and test some things

            TrackCoach trackCoach = beanContainer.getBean("trackCoachBean", TrackCoach.class);

            System.out.println(trackCoach.getDailyWorkout());
            System.out.println(trackCoach.getMotivation());

            // Are the MotivationalServices the same object?
            System.out.println("Are the motivational services the same? " +
                    (baseballCoach.getMotivationalService() == trackCoach.getMotivationalService()));

            System.out.println("Are the workout services the same? " +
                    (baseballCoach.getWorkoutService() == trackCoach.getWorkoutService()));

            System.out.println("------------------------------------------");

            BasketballCoach basketballCoach = beanContainer.getBean("basketballCoachBean", BasketballCoach.class);

            // We should be able to check the fields like before
            System.out.println(basketballCoach.getDailyWorkout());
            System.out.println(basketballCoach.getMotivation());
            System.out.println(basketballCoach.getEmail());
            System.out.println(basketballCoach.getTeamName());

        } catch (Exception e){
            e.printStackTrace();
        }


    }
}