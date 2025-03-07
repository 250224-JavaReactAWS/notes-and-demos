package com.revature.collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class QueueDriver {

    /*
    A Queue data structure is a data structure that follows the FIFO principle (First In, First Out). Simply this is
    like a line that you see anywhere in the world.

    Queues are dynamic in size and they retain their order. The Queue Interface is implemented by several classes:
    LinkedList, PriorityQueue, ArrayDeque
     */

    public static void main(String[] args){

        Queue<String> amusementParkLine = new LinkedList<>();

        // Queues are designed for FIFO
        amusementParkLine.add("John");
        amusementParkLine.add("Anthony");
        amusementParkLine.add("Daniel");
        amusementParkLine.add("Walter");
        amusementParkLine.add("Aaron");

        // Print out each name
        System.out.println(amusementParkLine);

        // Let's look at a few other methods
        // Since a Queue is a Collection it is Iterable
        for (String lineMember: amusementParkLine){
            System.out.println(lineMember);
        }

        System.out.println("------------------------------");

        // How do we go about taking them out of the line?
        // The first ways to look at who is in the queue is to view who is first in line
        // We do this with the peek() method which returns the first element but DOES NOT remove it
        System.out.println(amusementParkLine.peek());

        // If we want to actually remove the first element and return it we use poll()
        System.out.println(amusementParkLine.poll());

        System.out.println(amusementParkLine.peek());

        // Get their size
        System.out.println(amusementParkLine.size());

        // Things can increase in complexity when we view a double ended queue

        // Doubled Ended Queue -> Deque
        Deque<Integer> numberDeque = new ArrayDeque<>();
        // An ArrayDeque is a double ended queue that holds elements in an array under the hood
        // Deques are just like Queues but you can poll/peek/remove/whatever on both sides

        numberDeque.add(1);
        numberDeque.add(2);
        numberDeque.add(3);
        numberDeque.add(4);
        numberDeque.add(5);
        numberDeque.add(6);
        numberDeque.add(7);

        System.out.println(numberDeque);

        // Poll first or Poll last
        System.out.println(numberDeque.pollFirst()); // 1
        System.out.println(numberDeque.pollLast()); // 7

        // Add first or add last
        numberDeque.addFirst(13);
        numberDeque.addLast(17);

        System.out.println(numberDeque);


        // When might this be useful
        // We can use a deque to implement a Stack
        // A stack is a data structure that represents LIFO (Last In First Out)
        // Function calls in Java are added to the stack and resolved in this LIFO order
        Deque<String> dishes = new ArrayDeque<>();

        // Collect some dishes from people
        dishes.add("Plate");
        dishes.add("Plate");
        dishes.add("Plate");
        dishes.add("Bowl");
        dishes.add("Bowl");
        dishes.add("Bowl");
        dishes.add("Cup");
        dishes.add("Cup");
        dishes.add("Spoon");

        // Clean the dishes by iterating over them and taking the last in first out
        // Unstacking
        int stackSize = dishes.size();
        for (int i = 0; i < stackSize; i++){
            System.out.println("Cleaning: " + dishes.pollLast());
        }
    }
}
