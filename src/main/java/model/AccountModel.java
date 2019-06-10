package model;

import entity.Account;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AccountModel {

    // Tìm theo account và password. Ps: không bao giờ được viết như thế này khi làm thật.
    public Account findByAccountAndPassword(String username, String password) {
        try {
            String sqlCommand = "select * from accounts where account = ? and password = ?";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String rsUserName = resultSet.getString(1);
                String rsPassword = resultSet.getString(2);
                String rsConfirmPassword = resultSet.getString(3);
                String rsEmail = resultSet.getString(4);
                String rsPhone = resultSet.getString(5);
                String rsAddress = resultSet.getString(6);
                int rsBalance = resultSet.getInt(7);
//                int rsStatus = resultSet.getInt(4);
                Account existAccount = new Account();
                existAccount.setUsername(rsUserName);
                existAccount.setPassword(rsPassword);
                existAccount.setBalance(rsBalance);
//                existAccount.setStatus(rsStatus);
                return existAccount;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public boolean save(Account account) {
        try {
            String sqlCommand = "insert into accounts (username, password, confirmpassword, email, phone, address, balance ) values (?,?,?,?,?, ?, ?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);
            preparedStatement.setString(1, account.getUsername());
            preparedStatement.setString(2, account.getPassword());
            preparedStatement.setString(3, account.getConfirmPassword());
            preparedStatement.setString(4, account.getEmail());
            preparedStatement.setString(5, account.getPhone());
            preparedStatement.setString(6, account.getAddress());
            preparedStatement.setInt(7, account.getBalance());
//            preparedStatement.setInt(4, account.getStatus());
            preparedStatement.execute();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public void saveUser(Account registerAccount) {
    }
//    public static void main(String[] args) {
//        AccountModel model = new AccountModel();
//        Account account = new Account();
//        account.setAccount("xuanhung1234");
//        account.setPassword("123");
//        account.setBalance(20000);
//        account.setStatus(1);
//        model.save(account);
//    }
}
