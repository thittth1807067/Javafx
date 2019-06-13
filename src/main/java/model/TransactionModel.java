package model;

import entity.Transaction;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TransactionModel {
    public boolean save(Transaction transaction) {
        try {
            String sqlCommand = "insert into transactions (senderId, receiveId, amount, message) values (?,?,?,?)";
            PreparedStatement preparedStatement = ConnectionHelper.getConnection().prepareStatement(sqlCommand);

            preparedStatement.setInt(1, transaction.getSenderId());
            preparedStatement.setInt(2, transaction.getReceiveId());
            preparedStatement.setInt(3, transaction.getAmount());
            preparedStatement.setString(4, transaction.getMessage());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
