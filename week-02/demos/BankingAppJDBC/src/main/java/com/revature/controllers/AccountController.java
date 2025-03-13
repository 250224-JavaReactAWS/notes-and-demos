package com.revature.controllers;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.services.AccountService;

import java.util.List;
import java.util.Scanner;

public class AccountController {
    /*
    This class is typically in charge of web traffic. But for this project it will be in charge of display
    functionality and coordinating various different service methods together as needed
     */

    private AccountService accountService;

    private Scanner scan;

    public AccountController(AccountService accountService, Scanner scan){
        this.accountService = accountService;
        this.scan = scan;
    }

    // TODO Create an Account
    public void createNewAccountHandler(int userId){
        // We need to take in info for the account
        // Let's get an account type and initial deposit

        System.out.println("Please enter 1 to make a Checking account or 2 to make a Savings account");
        String choice = scan.nextLine();

        while (!(choice.equals("1") || choice.equals("2"))){
            System.out.println("Invalid selection. Please pick 1 or 2");
            choice = scan.nextLine();
        }

        // Ternary Operator
        // Simple way to do an if-else statement when setting variables or as a function argument
        // Condition ? valueIfTrue : valueIfFalse

        AccountType type = choice.equals("1") ? AccountType.CHECKING : AccountType.SAVINGS;

        // Let's take in an initial deposit
        System.out.println("Please enter in an amount for an initial deposit");

        String depositString = scan.nextLine();
        // Parse to a double
        Double initialDeposit = null;
        do{
            try{
                initialDeposit = Double.parseDouble(depositString);
            } catch (NumberFormatException e){
                System.out.println("Invalid value for initial deposit, please enter a new value");
                depositString = scan.nextLine();
            }
        } while(initialDeposit == null);

        // If we get here everything should be ok so let's try to create the account
        try {
            Account a = accountService.createAccount(userId, type, initialDeposit);
            System.out.println("Created New Account: ");
            System.out.println(a);
        } catch (IllegalArgumentException e){
            System.out.println("Could not create account");
        }





    }

    // TODO View ALL Accounts
    public void viewAllAccountsHandler(){
        // This will display all accounts
        List<Account> allAccounts = accountService.getAllAccounts();

        System.out.println("All Accounts: ");
        for(Account a: allAccounts){
            System.out.println(a);
        }
    }

    // TODO View a user's accounts
    public void viewUsersAccountsHandler(int userId){
        // This will display all accounts
        List<Account> allAccounts = accountService.getUsersAccounts(userId);

        System.out.println("All Accounts: ");
        for(Account a: allAccounts){
            System.out.println(a);
        }
    }

    // Todo Deposit
    public void depositToAccountHandler(int userId){
        // Take in the account they want to update
        System.out.println("Enter the account number for the account you want to update");
        String accountString = scan.nextLine();
        int accountId = Integer.parseInt(accountString);
        // Validate they own the account
        if (!accountService.ownsAccount(accountId, userId)){
            System.out.println("You don't own that account! Aborting deposit");
            return;
        }

        System.out.println("Enter the amount you wish to deposit");
        double amount = Double.parseDouble(scan.nextLine());

        // Make the deposit
        Account updatedAccount = accountService.depositMoney(accountId, amount);

        if (updatedAccount == null){
            System.out.println("Unable to deposit");
        } else {
            System.out.println("Deposit successful for account: " + accountId);
        }
    }

    // Todo Withdrawal

    // Todo transfer
}
