package com.revature.exceptions;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.Scanner;

public class ExceptionDriver {

    /*
    Exceptions in Java are an important topic as they basically cover what to do when something goes wrong inside
    your Java code. There are two major types: Checked and Unchecked, sometimes also called Compile Time and Runtime
    exceptions.

    Checked Exceptions -> Compile Time exceptions, exceptions the compiler KNOWS to be on the lookout for
        - IOException
        - SQLException

    Unchecked Exceptions -> Runtime Exceptions, happen during the execution of the program itself
        - ArrayIndexOutOfBoundsException
        - NumberFormatException
        - NullPointerException

    ALL checked exceptions inherit from Exception. All Unchecked exceptions inherit from RuntimeException

    NOTE: Exceptions and Errors are completely different in Java. Errors are usually critical failures, typically
    dealing with hardware or fundamental issues with your code, whereas exceptions are reasonably expected to be able
    to recover from. The only similarity is that both Errors and Exceptions are THROWN
        - OutOfMemoryError (we ran out of memory in our application)
        - StackOverflowError (We're calling too many methods that never resolve, this can happen when using recursion)

    In a try-catch block there are a couple other properties we should know about.
        - Multiple Catch Blocks
            - You can have multiple catch blocks for a try block, but they have to be ordered from most specific
            exception to least specific. i.e a FileNotFoundException -> IOException -> Exception
        - Try-Catch-Finally Blocks
            - The finally block is an optional piece of code that will run whether or not an exception is thrown. Try ->
            finally OR try->catch (exception occurred)->finally
            - Technically you can have try-finally block and skip catch entirely but this isn't recommended

     */

    public static void main(String[] args){
        // What causes an exception?
        // Any java does not know how the handle the code you've given it, it will throw an exception

        int[] arr = {1,2,3,4,5}; // Indexes 0-4

        for (int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
            // This causes an ArrayIndexOutOfBoundsException here because we're trying to access arr[5]
            // Exceptions halt the execution of the program and unless properly handled the code will stop running
            // entirely
        }

        // There are a whole host of different kinds of exceptions you can run into in Java
        // ArrayIndexOutOfBoundsException
        // NumberFormatException
        // NullPointerException

        // Every time an exception is thrown you should read the stack trace and determine what the error is from
        // the items it provides: Exception Name, Exception Message and Exception Location

        // What happens if I try to parse in a number that isn't actually a number?
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        String input = scan.nextLine();
        // Parse the string into a number
        // Wrapper classes can do this easily
        try{
            // Danger code that might throw an exception lives inside of here
            int num = Integer.parseInt(input); // Converts the string to a number
            System.out.println("The square of your number is " + num*num);
        } catch (NumberFormatException e){
            // This code excutes in the event of an Exception and will prevent the program from halting
            // e.printStackTrace();// This prints the stack trace but allows the program to continue
            // Alternate logic to handle the exception
            System.out.println("We encountered a number format exception, you did not enter a valid number!");
        }

        // How do I get around this?
        // Need to be able to HANDLE an exception
        // The main way to do this is with a try-catch block
        // You surround the dangerous code with a try block and "catch" any exceptions that are thrown



        // Checked Exceptions
        // These are exceptions that can occur whenever code is run that implicitly might be dangerous
        // IO or Input/Output is a common set of operations where you read/write to a file(s)
        // A common thing that can go wrong is not finding the file
        try{
            FileInputStream inputStream = new FileInputStream("Test.txt");
        } catch (FileNotFoundException e){
            // e.printStackTrace();
            System.out.println("File was not found");
        }

        // The above line of code has a CHECKED exception that basically says there is a possibility the file might
        // not be found and you need to handle this before executing the code
        // Since we need to handle this, let's wrap it in a try-catch block

        try{
            throwsAnException();
        } catch (FileNotFoundException e){
            System.out.println("Caught the ducked exception");
        }

        try{
            directlyThrowsAnException();
        } catch (SQLException e){
            // SQL Exception is caught here
        } catch (Exception e){
            // General Exception here
        }

        try{
            throwsCustomCheckedException();
        } catch (CustomCheckedException e){
//            e.printStackTrace();
            System.out.println("Custom Checked Exception thrown");
        } catch (Exception e){
            // This catch block is MORE general than the previous one so it goes after
            System.out.println("Generic Exception");
        }

//        throwsCustomUncheckedException();


        try{
            System.out.println("Enter a number: ");
            input = scan.nextLine();
            int num = Integer.parseInt(input);
            System.out.println("Your number squared is " + num*num);
        } catch(NumberFormatException e){
            System.out.println("The number you entered was not a number");
        } finally{
            // Runs whether the code works or does not
            System.out.println("This code runs whether the block completes or throws an exception");
        }

    }

    public static void throwsAnException() throws FileNotFoundException{
        // What if you write some method that has dangerous code in it but you don't want to handle it directly within
        // the method itself
        FileInputStream inputStream = new FileInputStream("Test.txt");

        // What if I want whoever calls this method to handle the Exception that may occur
        // To do this we need to DUCK the exception
        // Declaring the method can throw the exception

        // Ducking the exception passes the responsibility of handling the exception to whoever calls the method itself
    }

    // Let's not just call a method that has a checked exception let's just throw one as well
    public static void directlyThrowsAnException() throws Exception{

        // If I want to throw an exception I will directly do so with the throw keyword
        throw new SQLException();
    }

    public static void throwsCustomCheckedException() throws CustomCheckedException{
        throw new CustomCheckedException("We threw our custom checked exception");
    }

    public static void throwsCustomUncheckedException(){
        throw new CustomRuntimeException("Throws a runtime exception");
    }
}
