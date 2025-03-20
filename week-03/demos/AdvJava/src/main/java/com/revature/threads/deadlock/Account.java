package com.revature.threads.deadlock;

public class Account {
    // This class is going to represent a simple bank account
    private int balance;

    private int transferCount;
    // The transfer count is a count of the amount of times a transfer has occurred


    // I want a method called transfer that allows me to send money to another account and update the object
    public void transfer(Account b, int amount){
        // Validate we have enough money
        if (amount > this.getBalance()){
            return;
        }

        // Reduce by the amount
        this.setBalance(this.getBalance()-amount);
        // Increase the other accounts value
        b.setBalance(b.getBalance() + amount);
        // Increase the transfer count
        this.transferCount++;
    }


    public Account(int balance) {
        this.balance = balance;
        this.transferCount = 0;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getTransferCount() {
        return transferCount;
    }

    public void setTransferCount(int transferCount) {
        this.transferCount = transferCount;
    }

    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", transferCount=" + transferCount +
                '}';
    }
}
