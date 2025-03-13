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
    public boolean transfer(int fromAccountId, int toAccountId, double amount) throws SQLException {
        // This method is going behave slightly differently because we want to use a transaction for it to make sure
        // it works all together
        Connection conn = ConnectionUtil.getConnection();
        try {
            // The first thing we need to do is update the connection and turn autoCommit off
            conn.setAutoCommit(false);

            String sql1 = "UPDATE ACCOUNTS SET balance = balance - ? WHERE account_id = ?"; // Withdrawal step
            String sql2 = "UPDATE ACCOUNTS SET balance = balance + ? WHERE account_id = ?"; // Deposit step

            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, amount);
            ps1.setInt(2, fromAccountId);

            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setDouble(1, amount);
            ps2.setInt(2, toAccountId);

            int rows1 = ps1.executeUpdate();
            int rows2 = ps2.executeUpdate();

            if (rows1 <= 0 || rows2 <= 0){
                throw new SQLException("Could not transfer");
            }

            // Save all of the updates
            conn.commit();
        } catch (SQLException e) {
            System.out.println("Could not perform transfer");
            //Rollback
            conn.rollback();
        } finally {
            conn.setAutoCommit(true);
        }


        return false;
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

        // Capture the connection
        try (Connection conn = ConnectionUtil.getConnection()){

            // Writing the SQL
            String sql = "SELECT * FROM ACCOUNTS WHERE ACCOUNT_ID = ?";

            // Prepared Statement
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);

            // Execute the statement
            ResultSet rs = ps.executeQuery();

            // Since this has at most 1 result
            if (rs.next()){
                Account returnedAccount = new Account(rs.getDouble("balance"),
                        AccountType.valueOf(rs.getString("type")),
                        rs.getInt("user_id"));

                returnedAccount.setAccountId(rs.getInt("account_id"));
                return returnedAccount;
            }

        } catch (SQLException e) {
            System.out.println("Unable to get account");
        }

        return null;
    }

    @Override
    public Account update(Account obj) {
        // Capture the connection
        try (Connection conn = ConnectionUtil.getConnection()){

            // Write out the SQL
            String sql = "UPDATE accounts SET balance = ? WHERE account_id = ?;";

            // Create the statement and inject values as needed
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setDouble(1, obj.getBalance());
            ps.setInt(2, obj.getAccountId());

            // This time I'll use the executeUpdate method
            // For things that don't create a resultset we can use the executeUpdate to return the number of
            // updated rows
            int rows = ps.executeUpdate();

            // If a row is updated then rows should be greater than 0
            if (rows > 0){
                return obj;
            } else {
                return null;
            }


        } catch (SQLException e) {
            System.out.println("Unable to update account");
        }

        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
