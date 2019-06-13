package controller;

import entity.Account;
import model.AccountModel;

public class RegisterController {
    private AccountModel registerAccountModel = new AccountModel();

    public void create(Account registerAccount) {
        registerAccountModel.saveUser(registerAccount);
    }
}