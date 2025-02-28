public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        /*
        This is a multiline comment in Java

        Java is an Object Oriented Programming language that is widely popular, platform independent and has nice
        features that make it good to use
            - Strongly typed
                - A Strongly typed language is a language where you declare the types and they do not change unless
                explicitly casted. This is different than a language like JavaScript where variable do not need to be
                declared with a datatype and can change at runtime
                - Syntax: datatype variableName = value
            - Compiled not interpreted
                - Compiled languages attempt to turn the entire code into byte code before execution ever begins. This
                means you need to check for syntax errors before you can ever execute the code. Interpreted languages
                like Python and JS are the opposite, if you have a syntax error the code will still run until it gets
                to that line since it is compiled one line at a time
         */

        // Declaring Variables in Java
        // We need to declare the datatypes of our variables in Java before we can use them. There are a series
        // of built in primitive datatypes that we can use

        int x = 10;

        boolean isChecked = false;

        // There are a variety of primitive datatypes that we can use
        /*
        Whole Number Datatypes:
            byte
            short
            int (probably the default you should choose)
            long
        Decimal Datatypes:
            float
            double (probably the default you should choose)
        Character Datatypes:
            char
        Boolean Datatypes:
            boolean
         */

        byte a = 1;
        short b = 10;
        int c = 1000; // Choose this for most whole numbers
        long e = 1000000L;
        float d = 3.14f;
        double g = 3.14159265; // Choose this for most decimals
        char h = 'H';
        boolean i = true;

        /*
        Strings
        Strings are similar to primitives, but it's important to note that String is a CLASS. The way we declare
        a string is slightly different to the primitives, notice how we write string

        Strings are a collection of chars
        String begin with a capital S
         */

        String bryan = "bryan";

        // What is the difference between a class and a primitives?
        // Classes and Objects have various methods associated with them that basic prims do not have

        // c.whatever doesn't bring up any functions
        bryan.contains("y");


        /*
        Operators
        These exist in Java as well as every other programming language and they allow you to interact with various
        variables and perform simple operations that can be combined together for various tasks

        Arithmetic Operators (Math)
            - +, -, *, /, %
        Assignment Operators (Assigning a value)
            - =, +=, -=, *=, /=, %=
        Comparison Operators (Performing Comparisons)
            - <, >, <=, >=, ==, !=
        Logical Operators (Used for combining operations)
            - &, &&, |, ||
            - Logical AND and logical OR
         */

        // Arithmetic
        int k = 4 + 7;
        int j = 17 - 36;
        int l = 17 * 3;
        int m = 52 / 4;
        int n = k % j; // Divide and take the remainder

        // Assignment operators
        // k is currently 11 I want to add 10 and reassign it to k
//        k = k + 10;
        k += 10;

        // Comparison Operators
        // Used to compare two values

        int s = 7;
        int t = 7;

        System.out.println("Is " + s + " less than " + t + "? " + (s < t));
        System.out.println("Is " + s + " greater than " + t + "? " + (s > t));
        System.out.println("Is " + s + " less than or equal to " + t + "? " + (s <= t));
        System.out.println("Is " + s + " greater than or equal to " + t + "? " + (s >= t));
        System.out.println("Is " + s + " equal to " + t + "? " + (s == t));
        System.out.println("Is " + s + " not equal to " + t + "? " + (s != t));


        // Logical Operators
        // These are used primarily for combining multiple pieces of comparison logic
        char shirtSize = 'S';
        double price = 9.99;

        // AND -> Only returns true if the left and right side are both true
        System.out.println("Is the shirt a medium and less than $10? " + (shirtSize == 'M' && price < 10));
        // OR -> Returns true if at least one side is true
        System.out.println("Is the shirt a small OR is the shirt more than $15? " + (shirtSize == 'S' || price > 15));
    }
}