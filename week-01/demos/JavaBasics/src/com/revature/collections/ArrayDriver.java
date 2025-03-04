package com.revature.collections;

import com.revature.oop.encapsulation.Employee;

public class ArrayDriver {

    /*
    Up until this point we've only dealt with single individual objects, this is usually not the only way we'll deal
    with data sometimes we'll have multiple values of the same type bunched together
     */

    public static void main(String[] args){

        // An Array is a simple collection of values
        // Temperatures
        int sundayTemp = 70;
        int mondayTemp = 80;
        int tuesdayTemp = 90;
        // and so on

        // Once I need to start doing more complex work I'll need to bunch these together into one object

        // Arrays in Java are FIXED LENGTH, indexed/ordered and they allow duplicate values
        // Arrays can be declared in a couple of ways
        int[] weekTemperatures = new int[7];
        // This creates an array of length 7, meaning it can hold at most 7 ints

        // Declare the values and length implicitly
        int[] weekTemps = {70, 80, 90, 65, 85, 75, 60};
        // Array of length 7 with all values specified
        String[] strings = {"A", "B", "C"};
//        strings[3] = "D";
        // The above is not possible since Arrays cannot be resized after creation

        // Now that we have an array let's look at what we can do

        // Arrays are indexed and everything in Java is 0 indexed
        // In an array of length 7, indices go from 0-6

        for (int i = 0; i < weekTemps.length; i++){
            // LENGTH IS A PROPERTY of ARRAYS that we can use
            // Print each value of the array
            System.out.println(weekTemps[i]);
        }


        // Common things you'll see with arrays
        // Max of an array
        // Minimum of an array
        // Average value of an array

        // To find the minimum, first initialize with the first value of the array
        int min = weekTemps[0];

        for (int i = 1; i< weekTemps.length; i++){
            if (weekTemps[i] < min){
                min = weekTemps[i];
            }
        }

        System.out.println(min);

        // Arrays are the simplest form of a collection of data but are somewhat limited because of the fixed size

        // Bad Practice
        // Creating data with varying types
        Object[] multipleTypeArray = {1, "String", false, new Employee()};
        // This is bad practice because you're getting rid of the type safety which is a feature of Java
    }
}
