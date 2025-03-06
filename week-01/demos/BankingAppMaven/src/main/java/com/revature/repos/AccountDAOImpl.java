package com.revature.repos;

import com.revature.models.Account;

import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public List<Account> getAllByUserId(int userId) {
        return List.of();
    }

    @Override
    public Account create(Account obj) {
        return null;
    }

    @Override
    public List<Account> getAll() {
        return List.of();
    }

    @Override
    public Account getById(int id) {
        return null;
    }

    @Override
    public Account update(Account obj) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
