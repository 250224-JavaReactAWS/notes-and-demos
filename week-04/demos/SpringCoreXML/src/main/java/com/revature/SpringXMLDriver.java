package com.revature;

import com.revature.models.BaseballCoach;
import com.revature.models.BasketballCoach;
import com.revature.models.TrackCoach;
import com.revature.services.MotivationalService;
import com.revature.services.WorkoutService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringXMLDriver {
    public static void main(String[] args) {
        // OLD SCHOOL WAY (No Spring)

        // Let's create our objects
        // Let's say I want a baseball coach

//        WorkoutService workoutService = new WorkoutService();
//        MotivationalService motivationalService = new MotivationalService();
//
//        BaseballCoach baseballCoach = new BaseballCoach(motivationalService, workoutService);

        System.out.println("Creating our bean container....");

        // We'll create an instance of our ApplicationContext which is our IoC (Inversion of Control) container
        // It creates and manages our Beans
        try(ClassPathXmlApplicationContext beanContainer = new ClassPathXmlApplicationContext("beans.xml")){
            System.out.println("Bean Container Created!");
            System.out.println("-----------------------");

            // At this point Spring has directly created and wired together our classes based off the beans.xml file

            // Let's make sure this thing works
            // Let's grab the bean from the container
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

            /*
            What's going on, why is there only one motivational service?
            This has to with BEAN SCOPES. There are 6 bean scopes that we can apply to our beans, the default is the
            SINGLETON SCOPE. A Singleton is a class with only a single instance, this is the default, and it will be
            how you use the beans for 90% of what you need.

            The other scopes are a little more niche
            Prototype -> Creates a new instance every time we need one
            The other 4 have to do with web requests

            Let's update our workout service bean to be a PROTOTYPE
             */

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