package com.revature.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDriver {

    /*
    Streaming was introduced in Java 8 to allow for better data processing and allowing us to move through data more
    efficiently and in a more logical flow

    These use functional interfaces and lambdas A LOT so it's a good way to get practice

    Intermediate Operations
        Operations that occur and return another stream (map, filter)
    Terminal Operations
        Operations that end the stream (Collection or a forEach or a reducer)
     */

    public static void main(String[] args) {
        List<String> bingoNums = Arrays.asList(
                "N40", "N46", "B12", "B6",
                "G53", "G42", "g15", "G15",
                "I12", "I90"
        );

        // Let's start streaming the data
        // This can be done with any sort of collection and we can use this to process the data in one clean pass

        bingoNums.stream()
                // Intermediate Operation
                .map(num -> num.toUpperCase()) // This is a method that applies some operation to EVERY term
                .filter(num -> num.startsWith("G")) // This will return a stream that has filtered out values
                .sorted()
                .distinct()
                //Terminal Operation
                .forEach(num -> System.out.println(num));

        // Why is this useful? Why might we want to do this?
        /*
        Streaming gives us an efficient way to parse through data. Additionally it implicitly LAZY until a terminal
        operation is called (none of the operations will occur until the final terminal method). It goes through the data
        with one clean pass
         */

        // We can turn a stream back into a collection
        List<String> gNumsOnly = bingoNums.stream()
                // Intermediate Operation
                .map(num -> num.toUpperCase()) // This is a method that applies some operation to EVERY term
                .filter(num -> num.startsWith("G")) // This will return a stream that has filtered out values
                .sorted()
                //Terminal Operation
                // If I want this as some sort of collection. I need to use a collector
                .toList();


        // Let's look at another reducer
        // We can get a single value when operating on the data
        // Maybe we'll get the max number could for bingo nums that being with I

        int maxINum = bingoNums.stream()
                .filter(num -> num.startsWith("I"))
                .map(bingoNum -> Integer.parseInt(bingoNum.substring(1)))
                // I could sort this and try to return the last value
                // Terminal Operation that just returns the max value
                .max(Integer::compareTo).get();

        System.out.println(maxINum);

    }
}
