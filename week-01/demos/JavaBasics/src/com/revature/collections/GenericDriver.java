package com.revature.collections;

public class GenericDriver {

    /*
    Before we can get to more complex data structures we'll need to take a look at Generics and Wrapper Classes

    Generics -> Are a way to create more dynamic classes that operate on a variety of types
     */

    public static void main(String[] args){
        // Let's use our generic class

        // Let's use the generic math class
        GenericMathClass<Integer> integerGeneric = new GenericMathClass<>();
        GenericMathClass<Double> doubleGeneric = new GenericMathClass<>();

        // In the variable declarations above I declared that the type of T for the first variable is Integer and
        // for the second variable it is a Double

        integerGeneric.add(3,5);
        doubleGeneric.add(3.14, 5.6);

        // The point of this is, we can dynamically change how a class operates for various types by doing the
        // above with generics. These will become important when we talk about collections after lunch

        // Why is int written as Integer and double as Double?
        /*
        Integer and Double (as well as Boolean, Byte, Short, Long, Float, and Char are WRAPPER CLASSES)
        A Wrapper class is a wrapper or box around a primitive to treat it like an object

        We use wrapper classes when we want to use primitive values in places that only accept classes (Generics)
        There's a process called unboxing and autoboxing.
         */

        // Autoboxing
        Integer i = 5;
        // Wrapper class = primitive (We need to box up the primitive value in a class)

        // Unboxing
        int j = Integer.valueOf(13);
        // Primitive = Wrapper Class object

    }
}
