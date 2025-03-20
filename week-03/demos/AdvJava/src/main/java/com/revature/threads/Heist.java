package com.revature.threads;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Heist {

    /*
    Right now all we've done is practice creating some threads, let's actually use them for something

    I'm going to have 2 hacker threads attempting to crack a "vault" and guess the password. One will start at 0 and
    one will start at 9999 and they'll move in opposite directions trying to crack the safe

    Afterwards we'll make a polica thread that will give them 15 seconds before it "catches" the hackers
     */

    public static final int MAX_PASSWORD=9999;

    public static void main(String[] args) {
        // Let's start by creating a vault with a secret password

        // Instantiating a random password
        Random random = new Random();
        int password = random.nextInt(MAX_PASSWORD); // 0-9999

        // Print out the password
        System.out.println("The secret password is " + password);
        Vault vault = new Vault(password);

        // Let's create a list of threads that we'll start
        List<Thread> threads = new ArrayList<>();

        // Add all our threads
        threads.add(new AscendingHackerThread(vault));
        threads.add(new DescendingHackerThread(vault));
        threads.add(new PoliceThread());


        // Start all of our threads
        threads.forEach((thread) -> thread.start());


    }
}

class Vault{
    private int password;

    public Vault(int password) {
        this.password = password;
    }

    // The hacker threads will constantly call a check method and if they're wrong we will make the thread wait for a
    // small amount of time
    public boolean isCorrectPassword(int guess){
        try {
            Thread.sleep(5);
            // Every guess takes 5 milliseconds
            // Pause the thread from execution for 5 milliseconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.password == guess;
    }
}

class AscendingHackerThread extends Thread{

    private Vault vault;

    // Take in a vault object and run a loop to guess passwords on the vault
    public AscendingHackerThread(Vault vault){
        this.vault = vault;
    }

    @Override
    public void run() {
        // In this thread we'll start at 0 and continue guessing numbers until we get to the password
        for (int guess = 0; guess < Heist.MAX_PASSWORD; guess++){
            if (vault.isCorrectPassword(guess)){
                System.out.println("Ascending Hacker found the password! It was " + guess);
                System.exit(0);
            }
        }
    }
}

class DescendingHackerThread extends Thread{

    private Vault vault;

    // Take in a vault object and run a loop to guess passwords on the vault
    public DescendingHackerThread(Vault vault){
        this.vault = vault;

        // We can set the name of this thread by using the class name
        this.setName(this.getClass().getSimpleName());
    }

    @Override
    public void run() {
        // In this thread we'll start at MAX_PASSWORD - 1 and continue guessing numbers until we get to the password
        for (int guess = Heist.MAX_PASSWORD-1; guess >= 0; guess--){
            if (vault.isCorrectPassword(guess)){
                System.out.println(this.getName() + " found the password! It was " + guess);
                System.exit(0);
            }
        }
    }
}

// Add on a police thread to catch the hackers after a set amount of seconds
class PoliceThread extends Thread{
    @Override
    public void run(){
        // Let's start a countdown from 15 to 0
        for (int i = 15; i >= 0; i--){
            // Every second I want to print out the remaining time before the hackers are caught
            try {
                Thread.sleep(1000);
                // Pause the thread for a whole second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(i + " seconds left!");
        }

        // If we make it through the loop this means the hackers were caught
        System.out.println("The police caught the hackers");
        System.exit(0);
    }
}


