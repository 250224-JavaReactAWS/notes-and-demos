package com.revature.misc;

import com.revature.models.User;

import java.util.Comparator;

public class SortByNameComparator implements Comparator<User> {


    /*
    Comparators are classes that are used in the sort method but do not belong to the original class and they
    typically define a custom ordering to them

    In this class I want to compare the names of two users

    If you wanted to combine different sorting columns you could use a comparator to do so.
     */


    // THIS METHOD HAS 2 USERS TO COMPARE
    @Override
    public int compare(User o1, User o2) {

        // Compare the names of the users
        // This method sorts alphabetically by first name
        // The compareTo method from the String class will allow us to compare string alphabetically
        if (o1.getFirstName().compareTo(o2.getFirstName()) > 0) {
            return 1;
        } else if (o1.getFirstName().compareTo(o2.getFirstName()) < 0){
            return -1;
        }
        return 0;
    }
}
