package com.revature.services;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.repos.AccountDAO;

import java.util.List;

public class AccountService {
    /*
    This class is in charge of business logic and coordinating different DAO layer methods together to
    handle functionality
     */

    private AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO){
        this.accountDAO = accountDAO;
    }

    // TODO Create an Account
    public Account createAccount(int userId, AccountType type, double initialDeposit){
        // Validation logic
        // Validate the balance is greater than 0
        if (initialDeposit < 0){
            // This is not possible and really should be an invalid argument
            throw new IllegalArgumentException("Initial Deposit must be positive");
        }

        // Create our account object
        Account accountToBeSaved = new Account(initialDeposit, type, userId);

        return accountDAO.create(accountToBeSaved);
    }


    // TODO View ALL Accounts
    public List<Account> getAllAccounts(){
        return accountDAO.getAll();
    }

    // TODO View a user's accounts
    public List<Account> getUsersAccounts(int userId){
        return accountDAO.getAllByUserId(userId);
    }

    // Todo Deposit
    // To deposit some money we should make sure we own the account that is getting deposited into and then
    // validate the amount is greater than 0 and then update the account to "deposit" that money

    public boolean ownsAccount(int accountId, int userId){
        // I want to make sure the appropriate person is accessing the account
        // Get the account by its id and validate the user id field
        Account returnedAccount = accountDAO.getById(accountId);

        if (returnedAccount == null || userId != returnedAccount.getUserId()){
            return false;
        }

        return true;
    }

    // The above method will be called by our controller class so when we run deposit we can assume the account is
    // correctly owned
    public Account depositMoney(int accountId, double amount){
        // Check the deposit
        if (amount < 0){
            throw new IllegalArgumentException("Deposited amount is less than 0");
        }
        // Get the current account
        Account a = accountDAO.getById(accountId);
        // Set the new balance
        a.setBalance(a.getBalance() + amount);
        // Update the account
        return accountDAO.update(a);
    }

    // Todo Withdrawal

    // Todo transfer
}
