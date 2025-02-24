public class Main {
    // This is a single line comment in Java
    /*
    This is a multiline comment in Java

    Java:
    - Object-Oriented Programming Language
        - Java being an Object Oriented programming language means it revolves around classes and objects
        - Everything inside of Java will be a class or some sort of similar structure
            - We will create instances of a class called an object
            - A class is a blueprint and an object is the object that is built

    - Strongly and Statically Typed
        - A strongly and statically typed language means that you have to declare a datatype whenever using a variable
        and that datatype will typically not change
        -Strong
            - int x = 10
        - Weakly typed language
            - let x = 10
            - x = "String"
            - x = true

    - Compiled language not interpreted
        - Certain languages fall under different categories based off how they're read into machine code
        - Compiled languages read the entire file and make sure there are no syntax errors before execution
            - Java
        - Interpreted languages compiled code one line at a time and will only stop once it reaches a syntax error
            - JavaScript
            - Python

    - Virtual Machine, Multiplatform
        - One of the biggest positives for Java is its portability and it's ability for WORA (Write-Once-Run-Anywhere)
        - Internally Java has an OS specific Virtual Machine called the JVM, the JVM allows code to be executed no
        matter the environment you're in, provided you have it installed.

    - Has a garbage collector
        - A garbage collector frees up memory by removing and destroying objects that no longer have references to them,
        this enables automatic memory management allowing your program to operate more efficiently

     */

    public static void main(String[] args) {
        System.out.println("Hello, World!");

        System.out.println("My Name is Bryan and I'm a Java Trainer. I've worked at Revature for the past 3 years");

        // Creating variables
        // In java whenever we create a variable we need to declare a datatype
        // Datatypes determine what sort of information is being stored inside the variable itself
        // There are 2 categories of datatypes: primitives and objects
        // Primitives are the most basic form of data storage we can use in Java
        // Objects are collection of various prims put together

        /*
         Primitives in Java
         - Whole Number Datatypes
            - byte
            - short
            - int (should be used as a default)
            - long
        - Decimal Datatypes
            - float
            - double (should be used as a default)
        - Boolean Datatype (true/false)
            - boolean
        - Character Datatype
            - char
         */

        // Variable declaration
        // datatype name = value;

        int x = 10;

        double y = 3.14;

        char B = 'B';

        boolean isMarried = false;

        // With Java being strongly typed we cannot change these types implicitly
        // x = 13.2;
        // This is known as type safety, you can never set a variable to an unexpected type. This has a couple of
        // benefits but the major 2 are reducing bugs from types and improved intellisense


        // Operators in Java
        // Operators in any language are used to manipulate data in some capacity or perform some operation

        // Arithmetic Operators (Math Operators)
        /*
        +, -, *, /
        +=, -=, *=, /=
        % (modulus)
         */

        int z = 3 + 2;

        // An assignment operator
        z *= 6;
        // z = z * 6;

        System.out.println(z);

        // Comparison Operators (Used to compare values)
        // >, <, >=, <=, !=, ==
        int a = 9;
        int b = 9;
        System.out.println("Is a greater than b? " + (a > b));
        // ctrl + D to duplicate a line in intellij
        System.out.println("Is a less than b? " + (a < b));
        System.out.println("Is a greater than or equal to b? " + (a >= b));
        System.out.println("Is a less than  or equal to b? " + (a <= b));
        System.out.println("Is a not equal to b? " + (a != b));
        System.out.println("Is a equal to b? " + (a == b));


        // Logical Operators (AND vs OR)
        // These will typically be used in for loops of if-else statements
        // These are used to combine different pieces of comparison logic

        // Let's say I want to buy a shirt, I will only buy the shirt if the size is L and the price is less than 20.00

        // Let's get the shirt size
        char size = 'M';

        // Let's represent the price with a double
        double price = 14.15;

        // What I want to do is combine different criteria to make a more complex comparison
        System.out.println("Is the shirt size large? " + (size == 'L'));
        System.out.println("Is the shirt cheaper than $20? " + (price < 20));

        // The AND operator: && allows us to combine these two pieces
        System.out.println("Should I buy the shirt? " + (size == 'L' && price < 20));
        // If both statements are true this will return true, any other case is false
        // In this case we can only buy the shirt if it is less than 20 dollars and it is a large

        // Logical OR: || Is used when either condition being true is enough to satisfy the true statement

        // In this case I would buy a shirt even if it isn't a large if the price was cheap enough
        // I would buy any shirt that's a large or if the shirt is less than $5
        System.out.println("------------------");
        System.out.println("Is the shirt size large? " + (size == 'L'));
        System.out.println("Is the shirt cheaper than $5? " + (price < 5));
        System.out.println("Should I buy the shirt? " + (size == 'L' || price < 5));

        // Logical AND
        // True + True -> True
        // True + False -> False
        // False + True -> False
        // False + False -> False

        // Logical OR
        // True + True -> True
        // True + False -> True
        // False + True -> True
        // False + False -> False

        // NOTE: In java there is also the & and | operators, so you can use & or && for AND and | or || for OR
        // the difference is that the doubles use short-circuiting so they operate slightly faster

    }
}