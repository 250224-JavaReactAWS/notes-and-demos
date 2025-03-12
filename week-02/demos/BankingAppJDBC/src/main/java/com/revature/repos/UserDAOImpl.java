package com.revature.repos;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.util.ConnectionUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO{
    @Override
    public User getUserByUsername(String username) {

        try(Connection conn = ConnectionUtil.getConnection()){

            // Create our SQL String
            // THIS STRING IS CAN BE SUBJECT TO SQL INJECTION
            // A SQL Injection attack is a cybersecurity attack where users attempt to execute SQL code
            // by injecting into regular user inputs

            // We need to sanitize our input by precompiling it using a PreparedStatement
            // Prepared statement is a special kind of SQL statement that escapes any special characters or code
            // that may be entered
            String sql = "SELECT * FROM USERS WHERE USERNAME = ?";

            // Create a prepared statement object
            PreparedStatement ps = conn.prepareStatement(sql);
            // Inject in the values
            // ? indices start at 1
            ps.setString(1, username);

            // Execute the query
            ResultSet rs = ps.executeQuery();

            // This will only return one user so we'll do IF rs.next()
            if(rs.next()){
                User u = new User();
                // Set the properties of the user
                // I can get info from the row in the table by doing
                // rs.getDatatype("column_name") or rs.getDatatype(1) <- column index

                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(Role.valueOf(rs.getString("role"))); // We need to cast this to an ENUM

                return u;
            }

        } catch (SQLException e) {
            System.out.println("Could not retrieve user by username");
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public User create(User obj) {
        // I'll swap to a try-with-resources for this
        // Try-with-resources is a special kind of try-catch block that takes in a closeable resource
        // Like our connection and executes the statements and at the end automatically closes the resource

        try (Connection conn = ConnectionUtil.getConnection()){

            // Adding returning * to the end will return the user directly added to the database
            String sql = "INSERT INTO USERS (first_name, last_name, username, password) VALUES " +
                    "(?, ?, ?, ?) RETURNING *;";

            PreparedStatement ps = conn.prepareStatement(sql);

            // Set the values
            ps.setString(1, obj.getFirstName());
            ps.setString(2, obj.getLastName());
            ps.setString(3, obj.getUsername());
            ps.setString(4, obj.getPassword());

            // Execute the statement
            ResultSet rs = ps.executeQuery();

            if (rs.next()){
                User u = new User();
                // Set the properties of the user
                // I can get info from the row in the table by doing
                // rs.getDatatype("column_name") or rs.getDatatype(1) <- column index

                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(Role.valueOf(rs.getString("role"))); // We need to cast this to an ENUM

                return u;
            }

        } catch (SQLException e) {
             System.out.println("Could not save user");
             e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<User> getAll() {
        List<User> allUsers = new ArrayList<>();
        // Whenever we want to execute our SQL statements we will need to do a couple of things

        // Capture the connection
        Connection conn = ConnectionUtil.getConnection();

        // Write out the SQL we want to execute
        String sql = "SELECT * FROM USERS";

        try {
            // We need to create Statement Object
            Statement stmt = conn.createStatement();

            // Using the statement to execute the SQL query
            // The results of the query will be in a ResultSet object
            ResultSet rs = stmt.executeQuery(sql);
            // The ResultSet is an object that represents the table returned when executing a query
            // It's important to note that it has a cursor to move through the entries and it starts above the table
            while (rs.next()){
                // The method rs.next returns a boolean value if there is a next row and it moves the cursor to that
                // next row if it exists

                // I need to extract the information from the result set, create a user with it and add that info
                // to the list of all users

                User u = new User();
                // Set the properties of the user
                // I can get info from the row in the table by doing
                // rs.getDatatype("column_name") or rs.getDatatype(1) <- column index

                u.setUserId(rs.getInt("user_id"));
                u.setFirstName(rs.getString("first_name"));
                u.setLastName(rs.getString("last_name"));
                u.setUsername(rs.getString("username"));
                u.setPassword(rs.getString("password"));
                u.setRole(Role.valueOf(rs.getString("role"))); // We need to cast this to an ENUM

                // Now I have a full user object
                allUsers.add(u);
            }



        } catch (SQLException e) {
            System.out.println("Could not get all users!");
            e.printStackTrace();
        }


        return allUsers;
    }

    @Override
    public User getById(int id) {
        return null;
    }

    @Override
    public User update(User obj) {
        return null;
    }

    @Override
    public boolean deleteById(int id) {
        return false;
    }
}
