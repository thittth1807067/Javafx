package stage;

import controller.RegisterController;

import entity.Account;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.AccountModel;
import mainThread.Main;


public class RegisterStage extends Stage {

    private static final int REGISTER_STAGE_WIDTH = 400;
    private static final int REGISTER_STAGE_HEIGHT = 400;
    private VBox vBox;
    private HBox titleBox;
    private GridPane gridPane;
    private HBox btnBox;

    private Label lblTitle;
    private Label lblUserID;
    private Label lblUsername;
    private Label lblPassword;
    private Label lblConfirmPwd;
    private Label lblEmail;
    private Label lblPhone;
    private Label lblAddress;
    private Label lblBalance;
    private TextField txtUserID;
    private TextField txtUsername;
    private PasswordField pwdPassword;
    private PasswordField pwdConfirmPassword;
    private TextField txtEmail;
    private TextField txtPhone;
    private TextField txtAddress;
    private TextField txtBalance;
    private Button btnSignUp;
    private Button btnReset;

    private Scene scene;
    private Stage stage;
    private Main main;
    private LoginStage loginStage;
    private AccountModel model;


    public RegisterStage(Main main) {
        this.model = new AccountModel();
        this.main = main;
        initComponent();
        this.scene = new Scene(this.vBox, REGISTER_STAGE_WIDTH, REGISTER_STAGE_HEIGHT);
        this.stage = this;
        this.stage.setScene(this.scene);
    }

    private void initComponent() {
        this.titleBox = new HBox();
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.setSpacing(10);
        this.lblTitle = new Label("Register");
        this.lblTitle.setStyle(" -fx-text-fill: #2d0fce;-fx-font: normal bold 18px 'serif' ");
        this.titleBox.getChildren().add(lblTitle);

        this.gridPane = new GridPane();
        this.gridPane.setPadding(new Insets(10));
        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);
        this.lblUserID = new Label("UserID");
        this.lblUsername = new Label("Username");
        this.lblPassword = new Label("Password");
        this.lblConfirmPwd = new Label("Confirm Password");
        this.lblEmail = new Label("Email");
        this.lblPhone = new Label("Phone");
        this.lblAddress = new Label("Address");
        this.lblBalance = new Label("Balance");
        this.txtUserID = new TextField();
        this.txtUsername = new TextField();
        this.pwdPassword = new PasswordField();
        this.pwdConfirmPassword = new PasswordField();
        this.txtEmail = new TextField();
        this.txtPhone = new TextField();
        this.txtAddress = new TextField();
        this.txtBalance = new TextField();
        this.btnSignUp = new Button("Sign Up");
        this.btnReset = new Button("Reset");


        this.btnBox = new HBox();
        this.btnBox.setPadding(new Insets(10));
        this.btnBox.setSpacing(10);
        this.btnBox.setAlignment(Pos.CENTER);
        this.btnBox.getChildren().addAll(this.btnSignUp, this.btnReset);
        this.gridPane.add(this.lblUserID, 0, 0);
        this.gridPane.add(this.txtUserID, 1, 0);
        this.gridPane.add(this.lblUsername, 0, 1);
        this.gridPane.add(this.txtUsername, 1, 1);
        this.gridPane.add(this.lblPassword, 0, 2);
        this.gridPane.add(this.pwdPassword, 1, 2);
        this.gridPane.add(this.lblConfirmPwd, 0, 3);
        this.gridPane.add(this.pwdConfirmPassword, 1, 3);
        this.gridPane.add(this.lblEmail, 0, 4);
        this.gridPane.add(this.txtEmail, 1, 4);
        this.gridPane.add(this.lblPhone, 0, 5);
        this.gridPane.add(this.txtPhone, 1, 5);
        this.gridPane.add(this.lblAddress, 0, 6);
        this.gridPane.add(this.txtAddress, 1, 6);
        this.gridPane.add(this.lblBalance, 0, 7);
        this.gridPane.add(this.txtBalance, 1, 7);
        this.gridPane.add(this.btnBox, 1, 8);

        this.vBox = new VBox();
        this.vBox.setPadding(new Insets(10));
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(10);
        this.vBox.getChildren().addAll(this.titleBox, this.gridPane);

//        this.loginStage = new LoginStage(main);
        this.btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                RegisterController registerController = new RegisterController();
                Account registerAccount = new Account(
                        Integer.parseInt(txtUserID.getText()),
                        txtUsername.getText(),
                        pwdPassword.getText(),
                        pwdConfirmPassword.getText(),
                        txtEmail.getText(),
                        txtPhone.getText(),
                        txtAddress.getText(),
                        Integer.parseInt(txtBalance.getText())
                );

                if (txtUsername.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter Username");
                } else if (pwdPassword.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter Password");
                } else if (pwdConfirmPassword.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter Confirm Password");
                } else if (txtEmail.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter email");
                } else if (txtPhone.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter phone");
                } else if (txtAddress.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter address");
                } else if (Integer.parseInt(txtBalance.getText()) < 50000) {
                    showAlert(Alert.AlertType.ERROR, "Please enter Balance greater than 50000");
                }
                registerController.create(registerAccount);
//                main.setIsRegistered(true);
                main.getLoginStage().show();
                txtUserID.clear();
                txtUsername.clear();
                pwdPassword.clear();
                pwdConfirmPassword.clear();
                txtEmail.clear();
                txtPhone.clear();
                txtAddress.clear();
                txtBalance.clear();
                stage.close();

            }
        });
        this.btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtUsername.clear();
                pwdPassword.clear();
                pwdConfirmPassword.clear();
                txtEmail.clear();
                txtPhone.clear();
                txtAddress.clear();
                txtBalance.clear();
            }
        });

    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);

        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.show();
    }

    public static int getRegisterStageWidth() {
        return REGISTER_STAGE_WIDTH;
    }

    public static int getRegisterStageHeight() {
        return REGISTER_STAGE_HEIGHT;
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

    public HBox getBtnBox() {
        return btnBox;
    }

    public void setBtnBox(HBox btnBox) {
        this.btnBox = btnBox;
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    public Label getLblUsername() {
        return lblUsername;
    }

    public void setLblUsername(Label lblUsername) {
        this.lblUsername = lblUsername;
    }

    public Label getLblPassword() {
        return lblPassword;
    }

    public void setLblPassword(Label lblPassword) {
        this.lblPassword = lblPassword;
    }

    public Label getLblConfirmPwd() {
        return lblConfirmPwd;
    }

    public void setLblConfirmPwd(Label lblConfirmPwd) {
        this.lblConfirmPwd = lblConfirmPwd;
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

    public TextField getTxtUsername() {
        return txtUsername;
    }

    public void setTxtUsername(TextField txtUsername) {
        this.txtUsername = txtUsername;
    }

    public PasswordField getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(PasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }

    public PasswordField getPwdConfirmPassword() {
        return pwdConfirmPassword;
    }

    public void setPwdConfirmPassword(PasswordField pwdConfirmPassword) {
        this.pwdConfirmPassword = pwdConfirmPassword;
    }

    public TextField getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(TextField txtEmail) {
        this.txtEmail = txtEmail;
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

    public Button getBtnSignUp() {
        return btnSignUp;
    }

    public void setBtnSignUp(Button btnSignUp) {
        this.btnSignUp = btnSignUp;
    }

    public Button getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
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

    public Label getLblBalance() {
        return lblBalance;
    }

    public void setLblBalance(Label lblBalance) {
        this.lblBalance = lblBalance;
    }

    public TextField getTxtBalance() {
        return txtBalance;
    }

    public void setTxtBalance(TextField txtBalance) {
        this.txtBalance = txtBalance;
    }

    public LoginStage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(LoginStage loginStage) {
        this.loginStage = loginStage;
    }
}