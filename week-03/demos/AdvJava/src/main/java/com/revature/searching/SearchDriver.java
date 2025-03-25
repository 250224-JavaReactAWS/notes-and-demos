package com.revature.searching;

import java.util.List;
import java.util.stream.IntStream;

public class SearchDriver {

    /*
    Let's pretend I had a list of integers sorted from 1-10000 but it's the numbers not divisible by 3 or 7 (idk this part)

    If I wanted to know if the number 2347 is in the list how would I go about finding that out?
    You'd probably follow some sort of pattern. We might start at the beginning of the list and check if the value is
    2347, if it isn't we moved to the next one
     */

    public static void main(String[] args) {

        List<Integer> nums = IntStream.rangeClosed(1,1000000).filter(num -> {
            if (num % 3 == 0 || num % 7 == 0) {
                return false;
            } else{
                return true;
            }
        }).boxed().toList();

        // Let's pretend we are given the list called nums but we don't know how it was created. If I want to find out
        // if the list contains a specific element I might do the following

        // Want the index value of 2347
        int index = -1;
        int linearOperations = 0;

        // Loop through the entire list and check each individual value
        for (int i = 0; i < nums.size(); i++){
            if (nums.get(i) == 987655){
                index = i;
                break;
            }
            linearOperations++;
        }

        System.out.println(index);
        System.out.println("How many operations did the linear search do? " + linearOperations);

        /*
        Going through the process of finding this index we repeated a set of steps over and over again until we finally
        go to an answer. This is an example of a simple Algorithm or a series of instructions that can be repeated to
        find some specific answer.

        Searching Algorithms
            - Linear Search
                - Check every element
            - Binary Search
                - Divide our searching area in half every time until we find the right value (list must be sorted)

        Sorting Algorithms
            - Bubble Sort
            - Merge Sort
         */

        // Let's try to find the values using a binary search

        int binaryIndex = -1;

        int target = 987655;

        int leftIndex = 0;
        int middleIndex = nums.size() / 2;
        int rightIndex = nums.size()-1;

        int binaryOperations = 0;

        while (leftIndex < rightIndex){
            // Check the middle value
            if (nums.get(middleIndex) == target){
                binaryIndex = middleIndex;
                break;
            } else if (nums.get(middleIndex) < target){
                // Middle index is greater than target
                // We need to chop off the right half
                leftIndex = middleIndex + 1;
                middleIndex = (rightIndex + leftIndex) / 2;
            } else {
                // Middle index is less than target
                // We need to chop off the left half
                rightIndex = middleIndex - 1;
                middleIndex = (rightIndex + leftIndex) / 2;

            }
            binaryOperations++;
        }

        // Let's try this
        System.out.println(binaryIndex);
        System.out.println("How many operations did our binary search take? " + binaryOperations);

        /*
        Why is knowing other algorithms important?
        They're not all made equal different algorithms have different time and space complexities

        Time complexity is a measure of the average amount of time it takes to complete the algorithm.

        This is measure with Big O notation, which is basically a representation of the amount of operations required to
        find the right value given a array/list of size n.

        Constant Time: O(1)
            - No matter the amount of inputs it should take 1 operation to get the answer
        Logarithmic Time: O(log n)
            - A bit slower than constant, take the logarithm of n and that's the worst case scenario
            - Binary Search
        Linear Time: O(n)
            - For n elements it will take n operations on average
            - Linear search
         */

    }


}
