package com.revature.threads.deadlock;

public class DeadlockDriver {

    /*
    In this class I'm going to simulate creating a deadlock

    A deadlock happens when two threads are locked waiting for other thread to release a lock on an object and nothing
    is happening.

    We ran our method and we saw that the threads eventually reached a state of BLOCKED and they would unblock no matter
    the amount of time we waited.

    This is a deadlock. A has locked an object in a synchronized block that B needs and vice versa. So A is waiting on
    B to release it's lock and B is waiting on A to release its lock.

    To resolve this we'll synchronize the objects in the exact same order every time
     */

    public static final int INITIAL_BALANCE = 1000;
    public static final int TRANSFER_RATE = 1;
    public static final int SLEEP_TIME = 1;

    public static void transferHelper(Account a, Account b){
        // This method is going to allow me to transfer from account A to account B

        for (int i = 0; i < INITIAL_BALANCE; i++){

            // When working with objects inside of threads it's important to use the SYNCHRONIZED keyword
            // Synchronized is a non-access modifier that allows only a single thread to access a variable at a time

            // I will synchronize A and then synchronize B so only one thread will update at a time
            synchronized (a){
                synchronized (b){
                    a.transfer(b, TRANSFER_RATE);
                }
            }

            // Delay the thread a bit after transfer
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }



    }

    public static void main(String[] args) {
        Account accountA = new Account(INITIAL_BALANCE);
        Account accountB = new Account(INITIAL_BALANCE);


        // I want to transfer the money from account A to account B
        Thread a = new Thread(() -> {
            // Transfer all of the money from a to b
//            transferHelper(accountA, accountB);
            safeSyncTransferHelper(accountA, accountB);
        });

        // In the second thread I want to transfer the money from account B to account A
        Thread b = new Thread(() -> {
            // Transfer all of the money from b to a
//            transferHelper(accountB, accountA);
            safeSyncTransferHelper(accountB, accountA);
        });


        // Let me create one more thread to monitor the other ones
        Thread monitor = new Thread(() -> {

            // This thread will monitor the STATES of the other threads and make sure everything is running smoothly
            while(a.isAlive() && b.isAlive()){
                System.out.println("Thread A State: " + a.getState() + " Thread B State: " + b.getState());
                System.out.println("Account A: " + accountA);
                System.out.println("Account B: " + accountB);

                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            System.out.println("Complete");
            System.out.println("Account A: " + accountA);
            System.out.println("Account B: " + accountB);
        });

        a.start();
        // Give this a bit of a head start
        try {
            Thread.sleep(300);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        b.start();
        monitor.start();
    }

    public static void safeSyncTransferHelper(Account sender, Account recipient){
        /*
        Problem from before: The accounts were synchronizing in opposite orders leading to a deadlock, we want to always
        synchronize them in the same way

        Using the hashcode of the account

        The hashcode is a number that represents the account
        If account A is the sender and has hashcode 3 and account b is the recipient and hashcode 2
        If account A is the recipient and has hashcode 3 and account b is the sender and hashcode 2
        We want to use the hashcodes to denote the order in which we sync our objects

        3 > 2 -> A is the sender and B is the recipient
        2 < 3 -> B is the sender and A is the recipient
        But either way we synchronize them as A and then B
         */

        Account A = sender.hashCode() > recipient.hashCode() ? sender : recipient;
        Account B = A.equals(sender) ? recipient: sender;

        for (int i = 0; i < INITIAL_BALANCE; i++){


            synchronized (A){
                synchronized (B){
                    sender.transfer(recipient, TRANSFER_RATE);
                }
            }

            // Delay the thread a bit after transfer
            try {
                Thread.sleep(SLEEP_TIME);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
