public class HelloStrings {
    // This is a new class which can have its own main method and act as its own program

    public static void main(String[] args){
        // As a reminder this is the entry point into our application, all of the code in this method
        // will be executed when we run the program

        // Strings
        // Strings are a collection of characters usually used to represent text
        // They're surrounded by "" and can be used anywhere you need text

        // NOTE: Strings are NOT primitives

        // Primitive variable
        int sample = 4;

        // Strings and other OBJECTS get called a little different
        String firstString = "Hello, World!";

        // Since a String is not a primitive there are methods associated with it
        System.out.println(firstString);

        // Strings are objects so there are methods / functions associated with them
        // We can use these methods to manipulate the string held inside the variable
        System.out.println(firstString.toLowerCase());
        System.out.println(firstString.toUpperCase());
        System.out.println(firstString.startsWith("Hello"));


        // There are a lot of methods associated with Strings some common ones are below
        // toLowerCase
        // toUpperCase
        // startsWith
        // charAt
        // substring
        // toCharArray
        // length
        // concat


        // It's important to note that strings in Java are IMMUTABLE (they cannot be changed)

        String secondString = "Sample Text.";

        // We can add on some more text by doing string concatenation
        secondString = secondString.concat(" Second Sentence.");

        System.out.println(secondString);

        // Strings are also stored in this thing called the String Pool
        // The string pool is a collection of all Strings that are used by the program
        // If one string is created and another string has the same value they will point to the same string in memory

        String s1 = "hello";
        String s2 = "hello";
        // this does NOT create 2 String objects, it creates one and that object has 2 pointers to it
        System.out.println(s1 == s2);
        System.out.println(s1.equals(s2));


        // This functionality changes whenever we use the String constructor
        String s3 = new String("Hello");
        String s4 = new String("Hello");
        // Let's try the same thing we did above
        System.out.println(s3 == s4);
        System.out.println(s3.equals(s4));
        // Both strings are just "Hello", why is s3 == s4 false?

        // What happens when checking equality for objects in Java we see that the == operator checks if the memory
        // address of the 2 objects are the same, whereas the .equals method checks the content of the object

        // This is important to note since when we check if two objects are equal to each other we want to see
        // if the values of the object are equal to each, not just located in the same place in memory

        // Let's check if two houses are equal to each other
        // Check if they have the same number of rooms
        // Check they have the same dimensions
        // Check that they have the same layout

        // You would not probably look at just the address of the house

        // TLDR: Use .equals for objects and == for primitives
    }
}
