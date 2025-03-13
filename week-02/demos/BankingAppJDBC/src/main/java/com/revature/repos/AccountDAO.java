package com.revature.repos;

import com.revature.models.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDAO extends GeneralDAO <Account>{

//    Account createAccount(Account account);
//
//    List<Account> getAllAccounts();
//
//    Account getAccountById(int accountId);
//
//    Account updateAccount(Account account);
//
//    boolean deleteAccountById(int accountId);

    // Other methods we might want
    // Maybe I want to get all of the accounts for a specific user
    List<Account> getAllByUserId(int userId);

    boolean transfer(int fromAccountId, int toAccountId, double amount) throws SQLException;
}
