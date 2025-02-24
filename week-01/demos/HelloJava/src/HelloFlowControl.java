import java.util.Scanner;

public class HelloFlowControl {

    public static void main(String[] args){
        // One of the final major pieces of our Java toolbox is control flow
        // Control flow refers to any structure that alters the flow of the code

        // Two major types of control flow
        // Branching statements
        // Branching statements only execute code when a specific condition is met
        // If-Else Statement
        // If the temperature is higher than 30 we'll call it hot

        int temperature = 22;

        // If this condition is true, execute this block
        if (temperature >= 30){
            System.out.println("It's a hot day!");
        } else if( temperature <= 10){
            System.out.println("It's a cold day!");
        } else{
            System.out.println("It's nice outside");
        }

        // Switch Cases
        // This is used for whenever you have a large list of if else statements
        // It's designed to make it look a little cleaner

        String dayOfWeek = "Saturday";

//        if (dayOfWeek == "Monday"){
//            System.out.println("Do leg workout");
//        } else if (dayOfWeek == "Tuesday"){
//            System.out.println("Do chest workout");
//        }

        switch (dayOfWeek){
            case "Monday":
                System.out.println("Do Legs Workout");
                break;
            case "Tuesday":
                System.out.println("Do Chest Workout");
                break;
            case "Thursday":
                System.out.println("Do Back Workout");
                break;
            default:
                System.out.println("Have a rest day");
        }

        // Looping statements
        // You want to use a loop whenever you're looking to REPEAT a piece of code
        // For Loops
        // Useful for when you know how many times you plan to loop
        String bryan = "Bryan";

        // Counting variable, Condition, Update function
        for(int i = 0; i < bryan.length(); i++){
            // This says that i starts at 0
            // It will loop until i == bryan.length()
            // i increases by 1 after each loop

            System.out.println(bryan.charAt(i));
        }

        // Enhanced For Loops (Revisit with data structures)


        // While Loops
        // Useful for looping an indefinite amount of times
        int secretNumber = 6;

        System.out.println("Guess a number 1-10");
        // To take in a number I will use the Scanner Class
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();
        // IMPORTANT TO NOTE, ALWAYS UPDATE YOUR CONDITIONAL VARIABLE
        while(guess != secretNumber){
            if (guess > secretNumber){
                System.out.println("A little high! Guess a lower number!");
            } else {
                System.out.println("A little low! Guess a higher number!");
            }
            guess = scan.nextInt();
        }
        System.out.println("You got it! The number was " + secretNumber);


        // Do While Loops
        // Do while loops always execute at least a single time before they stop even if the condition is false
        int test = 10;
        do{
            System.out.println("Number is not ten");
        } while (test != 10);

        // This is typically used for initialization setups, we probably won't have a lot of mileage with this but
        // we need to know it exists

    }
}
