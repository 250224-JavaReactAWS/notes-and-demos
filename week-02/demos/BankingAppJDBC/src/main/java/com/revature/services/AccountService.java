package com.revature.services;

import com.revature.models.Account;
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

    // TODO View ALL Accounts
    public List<Account> getAllAccounts(){
        return accountDAO.getAll();
    }

    // TODO View a user's accounts
    public List<Account> getUsersAccounts(int userId){
        return accountDAO.getAllByUserId(userId);
    }

    // Todo Deposit

    // Todo Withdrawal

    // Todo transfer
}
