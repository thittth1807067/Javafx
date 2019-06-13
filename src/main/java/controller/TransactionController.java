package controller;

import entity.Transaction;
import model.TransactionModel;

public class TransactionController {
    private TransactionModel transactionModel = new TransactionModel();
    public void create(Transaction transaction) {
        transactionModel.save(transaction);
    }
}
