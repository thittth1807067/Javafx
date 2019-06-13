package model;

import entity.Account;
import entity.EditAccount;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountModel {

    // Tìm theo account và password. Ps: không bao giờ được viết như thế này khi làm thật.
    public Account findByAccountAndPassword(String username, String password) {
        try {
            String sqlCommand = "select * from accounts where username = ? and password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                int rsUserID = resultSet.getInt(1);
                String rsUsername = resultSet.getString(2);
                String rsPassword = resultSet.getString(3);
                String rsConfirmPassword = resultSet.getString(4);
                String rsEmail = resultSet.getString(5);
                String rsPhone = resultSet.getString(6);
                String rsAddress = resultSet.getString(7);
                int rsBalance = resultSet.getInt(8);
                Account existAccount = new Account();
                existAccount.setUserID(rsUserID);
                existAccount.setUsername(rsUsername);
                existAccount.setPassword(rsPassword);
                existAccount.setConfirmPassword(rsConfirmPassword);
                existAccount.setEmail(rsEmail);
                existAccount.setPhone(rsPhone);
                existAccount.setAddress(rsAddress);
                existAccount.setBalance(rsBalance);
                return existAccount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Account search(int userID){
        try {
            String sqlCommand = "select * from accounts where userID = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setInt(1,userID);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                int rsUserId = resultSet.getInt(1);

                Account transaction = new Account();
                transaction.setUserID(rsUserId);
                return transaction;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean saveUser(Account account) {
        try {
            String sqlCommand = "insert into accounts (userID, username, password, confirmPassword, email, phone, address, balance) values (?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);

            preparedStatement.setInt(1, account.getUserID());
            preparedStatement.setString(2, account.getUsername());
            preparedStatement.setString(3, account.getPassword());
            preparedStatement.setString(4, account.getConfirmPassword());
            preparedStatement.setString(5, account.getEmail());
            preparedStatement.setString(6, account.getPhone());
            preparedStatement.setString(7, account.getAddress());
            preparedStatement.setInt(8, account.getBalance());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean edit(String account, String password, EditAccount editAccount ){
        try {
            String sqlCommand = "update  accounts set username=?,password = ?, confirmPassword= ?, email=?, phone= ? , address =? WHERE username = ? and password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, editAccount.getUsername());
            preparedStatement.setString(2, editAccount.getPassword());
            preparedStatement.setString(3, editAccount.getConfirmPassword());
            preparedStatement.setString(4, editAccount.getEmail());
            preparedStatement.setString(5, editAccount.getPhone());
            preparedStatement.setString(6, editAccount.getAddress());
            preparedStatement.setString(7,account);
            preparedStatement.setString(8,password);
            preparedStatement.executeUpdate();
            return true;
        } catch (Exception ex) {
            System.out.println("Error:" + ex.getMessage());
        }
        return false;
    }

}
