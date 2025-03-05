package com.revature.models;

public class Account {

    private int accountId;

    private double balance;

    private AccountType type;

    private int userId;
    // This final field is in charge of linking this account to a specific user
    // We'll talk in detail about why this is here when we get to SQL

    // Constructors
    private static int accountIdCounter = 10000;

    public Account(double balance, AccountType type, int userId){
        this.balance = balance;
        this.type = type;
        this.userId = userId;

        this.accountId = accountIdCounter;
        accountIdCounter++;
    }

    // Getters and Setters
    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
