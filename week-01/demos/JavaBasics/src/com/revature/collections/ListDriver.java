package com.revature.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class ListDriver {
    /*
    Lists are one of the most commonly used data structures out there. They're similar to arrays in Java but with one
    major difference

    Lists in Java are DYNAMIC in size, they are ordered/indexable, and they allow duplicates. Arrays in Java are fixed
    in size whereas Lists are not.

    As a reminder, List is an INTERFACE in Java so we need an implementing class to use the List methods
    - ArrayList
        - ArrayLists store information in an array under the hood. This makes them very fast at retrieval of data
        but slower at insertion/deletion of data
    - LinkedList
        - A LinkedList stores info in a series of nodes with pointers to the next node. This make traversal/retrieval
        slower than an ArrayList, but it's much faster at insertion/deletion.
     */

    public static void main(String[] args){

        // Let's create our first list
        List<String> cart = new ArrayList<>();
        // This creates a list of String objects that we can add to and do various things with

        cart.add("Eggs");
        cart.add("Milk");
        cart.add("Bread");
        cart.add("Chicken");
        // The list will grow dynamically as needed to account for more items. Arrays DO NOT DO THIS

        // Various methods associated with lists
        // Let's get the length of the cart
        System.out.println("How many items are in our cart? " + cart.size());

        // Let's check if bread is on the list
        System.out.println("Is bread on the list? " + cart.contains("Bread"));

        // Let's remove bread and test again
        cart.remove("Bread");
        System.out.println("Is bread on the list? " + cart.contains("Bread"));

        // Let's get an item at a specific index
        System.out.println("What is the first item on the list? " + cart.get(0));

        // Update the eggs
        cart.set(0, "18 count of Eggs");
        System.out.println("What is the first item on the list? " + cart.get(0));

        // Let's print every item from the list
        System.out.println("------------------");

        for (int i = 0; i < cart.size(); i++){
            System.out.println(cart.get(i));
        }

        System.out.println("------------------");

        // TODO Utility Classes
        Collections.sort(cart);
        // This line sorts the list alphabetically

        // Enhanced For-Loop
        // This allows us to iterate over iterable structures in Java and do something for each item in the collection
        // We LOSE ACCESS to the indexing variable so if you need that do not use this

        for (String s : cart){
            System.out.println(s);
        }

        System.out.println("------------------");

        // Clear the cart
        cart.clear();
        System.out.println("Is the cart empty? " + cart.isEmpty());

    }
}
