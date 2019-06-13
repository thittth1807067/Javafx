package controller;

import entity.EditAccount;
import model.AccountModel;

public class EditController {
    private AccountModel accountModel = new AccountModel();
    private String password;
    private String username;

    public void update(EditAccount editAccount) {

        if (accountModel.findByAccountAndPassword(username, password) != null) {
            accountModel.edit(username, password, editAccount);
        }
    }

}
