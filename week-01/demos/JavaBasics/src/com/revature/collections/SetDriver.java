package com.revature.collections;

import java.util.HashSet;
import java.util.Set;

public class SetDriver {
    /*
    Sets are our next Collection interface. Typically a set is similar to a mathematical definition of a set and it
    has the following properties
    - Unordered
    - Do not allow duplicates
    - Dynamic in size

    Set is an INTERFACE with a few implementing classes
    - HashSet
    - TreeSet
     */

    public static void main(String[] args){

        Set<Integer> studentIds = new HashSet<>();
        // NOTICE: We're using the Integer wrapper class so we can use this with ints

        // Let's add in several student ids
        studentIds.add(101);
        studentIds.add(102);
        studentIds.add(103);
        studentIds.add(101); // Sets do not allow duplicates, let's see what happens. This line gets ignored

        System.out.println("Student Ids: " + studentIds);
        // It's important to note that this will not always perserve order
        // With a list we can see what element is at a specific index
        // We can check if the list contains a value as follows

        System.out.println("Does the Set contain id: 102? " + studentIds.contains(102));

        // We can remove elements
        studentIds.remove(103);

        System.out.println(studentIds);

        // Clear
        studentIds.clear();
        System.out.println("Is the set empty? " + studentIds.isEmpty());

        // Let's see if we can get a Set with uncertain ordering
        Set<String> stringSet = new HashSet<>();

        stringSet.add("Hello");
        stringSet.add("Goodbye");
        stringSet.add("Hi");
        stringSet.add("Java");
        stringSet.add("Python");
        stringSet.add("JavaScript");
        stringSet.add("TypeScript");

        System.out.println(stringSet);
        // This order is not preserved and is not alphabetical. In a hash set, every value is Hashed and the
        // hashed value is what is used to order them

        stringSet.remove("Python");
        System.out.println(stringSet);
    }
}
