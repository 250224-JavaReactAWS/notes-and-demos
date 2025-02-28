import java.util.Random;
import java.util.Scanner;

public class ControlFlow {

    // Main method contains code to be executed
    public static void main(String[] args){
        /*
        Control flow are code blocks that directly affect the flow of the code. Typically, we flow from top to
        bottom with no deviations but we can use control flow to change that

        Branching Statements
            - If/Else statement
            - Switch Case

        Looping/Repeated Statements
            - For Loop
            - While Loop
            - Do While Loop
         */


        // If else Statements are branching statements that change the code that gets executed based off a conditional
        // statement. A conditional statement is a piece of code that evaluates to true or false

        int grade = 69;

        // GOAL: Print out the letter grade for the number
        // A -> 90+
        // B -> 80-89
        // C -> 70-79
        // Anything else is an F

        if (grade >= 90){
            // This statement gets completely skipped if the grade is less than 90
            System.out.println("A");
        } else if (grade >= 80){
            // Numbers like 90 or 91 do NOT trigger this block because it only executes the first conditional block
            // it passes
            System.out.println("B");
        } else if (grade >= 70){
            System.out.println("C");
        } else {
            // This block only executes if no other condition has passed
            System.out.println("F");
        }


        // TODO Switch Case
        // The switch case is another type of branching statement. It's useful when you have a lot of if-else cases
        // where you're checking for equality

        // Create a switch case for checking perfect squares up to 25
        int num = 16;

//        if (num == 1){
//            System.out.println("Number is 1^2");
//        } else if (num == 4){
//            System.out.println("Number is 2^2");
//        } else if (num == 9){
//            System.out.println("Number is 3^2");
//        } else if (num == 16){
//            System.out.println("Number is 4^2");
//        } else if (num == 25){
//            System.out.println("Number is 5^2");
//        } else {
//            System.out.println("Number is not a perfect square between 1-25");
//        }

        // Switch case version
        switch(num){
            case 1:
                System.out.println("Number is 1^2");
                break;
            case 4:
                System.out.println("Number is 2^2");
                break;
            case 9:
                System.out.println("Number is 3^2");
                break;
            case 16:
                System.out.println("Number is 4^2");
                break;
            case 25:
                System.out.println("Number is 5^2");
                break;
            default:
                System.out.println("Number is not a perfect square between 1-25");
        }


        // Looping Statements
        // These are useful any time we want to loop or repeat a block of code some amount of times

        // For Loops
        // Useful for when you know the exact amount of times you want to loop

        // Print all the numbers from 1-100 that are divisible by 25
        // Counting variable, condition to stop, update statement
        for (int i = 1; i <= 100; i++){
            // i starts at 1, will run while it's less than or equal to 100, it will increment by 1 every loop
            if (i % 25 == 0){
                System.out.println(i);
            }
        }

        // While Loops
        // Useful when you loop an indefinite amount of times

        // Guessing Game
        // Let's add a random number
        Random rand = new Random();
        int secretNumber = rand.nextInt(1000) + 1;

        // We are going to loop until our user guesses the number 7
        // Let's use Scanner to get user input
        System.out.println("Guess a number between 1-1000");
        Scanner scan = new Scanner(System.in);
        int guess = scan.nextInt();
//        int guess = secretNumber;

        while (guess != secretNumber){
//            System.out.println("The guess is wrong, guess again!");
            if (guess < secretNumber){
                System.out.println("Guess is too low");
            } else {
                System.out.println("Guess is too high");
            }

            // Always update your conditional in a while loop, otherwise you may get an infinite loop
            guess = scan.nextInt();
        }

        System.out.println("You got it! The number was " + secretNumber);

        // For those curious you can always guess a number between 1-100 within 7 guesses
        // Binary searching
        // Split the list in half every time until you narrow down the results
        // 100 is between 2^6 and 2^7 so it will take at most 7 guesses
        // 1000 is between 2^9 and 2^10 so it will take at most 10 guesses

        // TODO Do-While loops

        // Do-while loops are useful for when you need to execute a block of code at least once before
        // checking the conditional. This is useful for things like initialization setups
        // Guaranteed to execute AT LEAST once
        // Upside-down while loop
        int num2 = 10;
        do{
            System.out.println("number is NOT 10");
        } while (num2 != 10);
    }
}
