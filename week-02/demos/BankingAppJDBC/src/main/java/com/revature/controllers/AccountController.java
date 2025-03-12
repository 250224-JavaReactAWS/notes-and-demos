package com.revature.controllers;

import com.revature.models.Account;
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

    // Todo Withdrawal

    // Todo transfer
}
