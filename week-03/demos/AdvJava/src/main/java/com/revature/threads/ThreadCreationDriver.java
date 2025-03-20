package com.revature.threads;

public class ThreadCreationDriver {

    /*
    Let's talk about MultiThreading
    Multithreading is a process where you divide your application into execution process known as threads and attempt
    to run them concurrently (at the same time).

    Why?
    Through Multithreading we can achieve parallel processing allowing us to do two things or more at once. If implemented
    correctly multithreading can greatly speed up your application processes.

    Pitfalls:
    Working with threads can be rather difficult especially for a beginner, so typically you'll end up using some sort
    of library or framework, for now we'll go through the basics

    How do you choose how to create a thread?
    If you can extend the Thread class that's the easiest and allows for the most direct control over the thread

    Java does not support multiple inheritance so if you're already extending a class then you'd need to use the runnable
    interface. The runnable interface is also better for smaller threads that can be described in a lambda
     */

    public static void main(String[] args) {
        // There are 2 major ways to go about creating a Thread

        // 1. Extending the Thread class
        Thread t1 = new MyThread();
        // Setting the name
        t1.setName("MyThread Class");
        // We can also set a priority that will allows us to try to get this thread to run sooner
        t1.setPriority(Thread.MAX_PRIORITY);

        // 2. Implementing the Runnable Interface
        // The Runnable interface is an alternative to the Thread Class and allows you to create runnable threads

        // 2a. Implementing Class
        Thread t2 = new Thread(new MyRunnable());

        // 2b. Anonymous Class
        // An anonymous class allows us to implement an interface and provide method bodies to its method without
        // create a whole new class
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("Running from the anonymous class");
            }
        });

        // 2c. Implementing the Runnable Interface with a lambda
        Thread t4 = new Thread(() -> {
            // This is an implementation for the run method from Runnable
            System.out.println("Printing from the lambda thread!");
        });

        // To start the thread and make it run I call the .start method
        t1.start();
        t2.start();
        t3.start();
        t4.start();

    }
}

class MyThread extends Thread{

    // I want to Override the Thread class method called run
    @Override
    public void run() {
        // Think of this method as a new main method for everything that you want to run on this thread
        System.out.println("Hello from " + this.getName());
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello from the Runnable implementing class!");
    }
}
