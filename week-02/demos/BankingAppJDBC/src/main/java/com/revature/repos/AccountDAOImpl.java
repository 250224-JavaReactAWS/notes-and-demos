package com.revature.repos;

import com.revature.models.Account;
import com.revature.models.AccountType;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDAOImpl implements AccountDAO {

    @Override
    public List<Account> getAllByUserId(int userId) {
        List<Account> allAccounts = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM ACCOUNTS WHERE USER_ID = ?";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();

            while (rs.next()){
                Account a = new Account();

                a.setAccountId(rs.getInt("account_id"));
                a.setBalance(rs.getDouble("balance"));
                a.setType(AccountType.valueOf(rs.getString("type")));
                a.setUserId(rs.getInt("user_id"));

                allAccounts.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Could not retrieve all accounts");
            e.printStackTrace();
        }

        return allAccounts;
    }

    @Override
    public Account create(Account obj) {
        try (Connection conn = ConnectionUtil.getConnection()){

            String sql = "INSERT INTO ACCOUNTS (balance, type, user_id) VALUES (?,?,?) RETURNING *;";

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, obj.getBalance());
            ps.setString(2, obj.getType().toString());
            ps.setInt(3, obj.getUserId());

            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                Account a = new Account();

                a.setAccountId(rs.getInt("account_id"));
                a.setBalance(rs.getDouble("balance"));
                a.setType(AccountType.valueOf(rs.getString("type")));
                a.setUserId(rs.getInt("user_id"));

                return a;
            }

        } catch (SQLException e) {
            System.out.println("Could not create account!");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public List<Account> getAll() {
        List<Account> allAccounts = new ArrayList<>();

        try(Connection conn = ConnectionUtil.getConnection()){

            String sql = "SELECT * FROM ACCOUNTS";
            // This takes in no user input so I don't need to be worried about a PreparedStatement

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()){
                Account a = new Account();

                a.setAccountId(rs.getInt("account_id"));
                a.setBalance(rs.getDouble("balance"));
                a.setType(AccountType.valueOf(rs.getString("type")));
                a.setUserId(rs.getInt("user_id"));

                allAccounts.add(a);
            }

        } catch (SQLException e) {
            System.out.println("Could not retrieve all accounts");
            e.printStackTrace();
        }

        return allAccounts;
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
