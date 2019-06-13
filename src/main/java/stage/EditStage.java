package stage;
import controller.EditController;
import entity.Account;
import entity.EditAccount;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainThread.Main;
import model.AccountModel;
import mainThread.Main;

public class EditStage extends Stage {

    private static final int EDIT_STAGE_WIDTH = 500;
    private static final int EDIT_STAGE_HEIGHT = 400;

    private VBox vBox;
    private HBox titleBox;
    private GridPane gridPane;

    private Label lblTitle;
    private Label lblAccount;
    private Label lblPassword;
    private Label lblConfirmPassword;
    private Label lblEmail;
    private Label lblPhone;
    private Label lblAddress;
    private int balance;
    private TextField txtAccount;
    private TextField txtEmail;
    private PasswordField pwdPassword;
    private PasswordField pwdCFPassword;
    private TextField txtPhone;
    private TextField txtAddress;
    private TextField txtBalance;
    private Button btnEdit;

    private AccountStage accountStage;
    private Scene scene;
    private Stage stage;
    private Main main;
    private AccountModel model;

    public EditStage(Main main){
        this.model = new AccountModel();
        this.main = main;
        this.initComponent();
        this.scene = new Scene(this.vBox, EDIT_STAGE_WIDTH, EDIT_STAGE_HEIGHT);
        this.stage =this;
        this.stage.setScene(this.scene);
        initModality(Modality.APPLICATION_MODAL);
    }

    private void initComponent() {
        this.titleBox = new HBox();
        this.lblTitle = new Label("Edit Account");
        this.titleBox.setSpacing(10);
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.getChildren().add(lblTitle);

        this.gridPane = new GridPane();
        this.lblAccount =new Label("Account");
        this.lblPassword = new Label("Password");
        this.lblConfirmPassword = new Label("Confirm password");
        this.lblEmail = new Label("Email");
        this.lblPhone = new Label("Phone");
        this.lblAddress = new Label("Address");
        this.txtAccount = new TextField();
        this.pwdPassword = new PasswordField();
        this.pwdCFPassword = new PasswordField();
        this.txtEmail = new TextField();
        this.txtPhone = new TextField();
        this.txtAddress = new TextField();
        this.gridPane.add(this.lblAccount,0,0);
        this.gridPane.add(this.txtAccount,1,0);
        this.gridPane.add(this.lblPassword,0,1);
        this.gridPane.add(this.pwdPassword,1,1);
        this.gridPane.add(this.lblConfirmPassword,0,2);
        this.gridPane.add(this.pwdCFPassword,1,2);
        this.gridPane.add(this.lblEmail,0,3);
        this.gridPane.add(this.txtEmail,1,3);
        this.gridPane.add(this.lblPhone,0,4);
        this.gridPane.add(this.txtPhone,1,4);
        this.gridPane.add(this.lblAddress,0,5);
        this.gridPane.add(this.txtAddress,1,5);
        this.btnEdit = new Button("Edit");
        this.gridPane.add(this.btnEdit,1,6);
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setHgap(5);
        this.gridPane.setVgap(5);

        this.vBox = new VBox();
        this.vBox.getChildren().addAll(this.titleBox, this.gridPane);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(10);

        btnEdit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                EditController editController = new EditController();
                EditAccount editAccount = new EditAccount(
                        txtAccount.getText(),
                        pwdPassword.getText(),
                        pwdCFPassword.getText(),
                        txtEmail.getText(),
                        txtPhone.getText(),
                        txtAddress.getText()
                );
                editController.update(editAccount);
                main.getAccountStage().show();
                txtAccount.clear();
                pwdPassword.clear();
                pwdCFPassword.clear();
                txtEmail.clear();
                txtPhone.clear();
                txtAddress.clear();
                stage.close();
            }
        });
    }

    public static int getEditStageWidth() {
        return EDIT_STAGE_WIDTH;
    }

    public static int getEditStageHeight() {
        return EDIT_STAGE_HEIGHT;
    }

    public VBox getvBox() {
        return vBox;
    }

    public void setvBox(VBox vBox) {
        this.vBox = vBox;
    }

    public HBox getTitleBox() {
        return titleBox;
    }

    public void setTitleBox(HBox titleBox) {
        this.titleBox = titleBox;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    public Label getLblAccount() {
        return lblAccount;
    }

    public void setLblAccount(Label lblAccount) {
        this.lblAccount = lblAccount;
    }

    public Label getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(Label lblPassword) {
        this.lblPassword = lblPassword;
    }

    public Label getLblConfirmPassword() {
        return lblConfirmPassword;
    }

    public void setLblConfirmPassword(Label lblConfirmPassword) {
        this.lblConfirmPassword = lblConfirmPassword;
    }

    public Label getLblEmail() {
        return lblEmail;
    }

    public void setLblEmail(Label lblEmail) {
        this.lblEmail = lblEmail;
    }

    public Label getLblPhone() {
        return lblPhone;
    }

    public void setLblPhone(Label lblPhone) {
        this.lblPhone = lblPhone;
    }

    public Label getLblAddress() {
        return lblAddress;
    }

    public void setLblAddress(Label lblAddress) {
        this.lblAddress = lblAddress;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public TextField getTxtAccount() {
        return txtAccount;
    }

    public void setTxtAccount(TextField txtAccount) {
        this.txtAccount = txtAccount;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
    }

    public PasswordField getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(PasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }

    public PasswordField getPwdCFPassword() {
        return pwdCFPassword;
    }

    public void setPwdCFPassword(PasswordField pwdCFPassword) {
        this.pwdCFPassword = pwdCFPassword;
    }

    public TextField getTxtPhone() {
        return txtPhone;
    }

    public void setTxtPhone(TextField txtPhone) {
        this.txtPhone = txtPhone;
    }

    public TextField getTxtAddress() {
        return txtAddress;
    }

    public void setTxtAddress(TextField txtAddress) {
        this.txtAddress = txtAddress;
    }

    public TextField getTxtBalance() {
        return txtBalance;
    }

    public void setTxtBalance(TextField txtBalance) {
        this.txtBalance = txtBalance;
    }

    public Button getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(Button btnEdit) {
        this.btnEdit = btnEdit;
    }

    public AccountStage getAccountStage() {
        return accountStage;
    }

    public void setAccountStage(AccountStage accountStage) {
        this.accountStage = accountStage;
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public AccountModel getModel() {
        return model;
    }

    public void setModel(AccountModel model) {
        this.model = model;
    }
}
