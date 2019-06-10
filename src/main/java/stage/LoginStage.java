package stage;

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
//import model.AccountModel;
import mainThread.MainApplication;
import model.AccountModel;
import sample.Main;

public class LoginStage extends Stage {

    private static final int LOGIN_STAGE_WIDTH = 400;
    private static final int LOGIN_STAGE_HEIGHT = 200;
    private VBox vBox;
    private HBox titleBox;
    private GridPane gridPane;
    private HBox btnBox;

    private Label lblTitle;
    private Label lblAccount;
    private Label lblPassword;
    private TextField txtAccount;
    private PasswordField pwdPassword;
    private Button btnLogin;
    private Button btnReset;
    private Button btnSignUp;

    private RegisterStage registerStage;
    private Scene scene;
    private Stage stage;
    private Main main;
    private AccountModel model;

    public LoginStage(MainApplication main) {
        this.model = new AccountModel();
        this.main = main;
        this.initComponent();
        this.scene = new Scene(this.vBox, LOGIN_STAGE_WIDTH, LOGIN_STAGE_HEIGHT);
        this.stage = this;
        this.stage.setScene(this.scene);
    }


    public void initComponent() {
        this.titleBox = new HBox();
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.setSpacing(10);
        this.lblTitle = new Label("Spring Hero Bank");
        this.lblTitle.setFont(Font.font(17));
        this.lblTitle.setTextFill(Color.web("#f9e70b"));
        this.titleBox.getChildren().add(lblTitle);

        this.gridPane = new GridPane();
        this.gridPane.setPadding(new Insets(10));
        this.gridPane.setVgap(10);
        this.gridPane.setHgap(10);
        this.lblAccount = new Label("Account");
        this.lblPassword = new Label("Password");
        this.txtAccount = new TextField();
        this.pwdPassword = new PasswordField();
        this.btnLogin = new Button("Login");
        this.btnReset = new Button("Reset");
        this.btnSignUp = new Button("Sign Up");

        this.btnLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account account = model.findByAccountAndPassword(txtAccount.getText(), pwdPassword.getText());
                if (account != null) {
                    main.setAccountName(account.getUsername());
                    main.setAccountBalance(account.getBalance());
                    main.getLblAccountName().setText(account.getUsername());
                    main.getLblBalanceValue().setText(String.valueOf(account.getBalance()));
                    main.setIsLoggedIn(true);
                    main.getStage().show();
                    stage.close();
                } else if (txtAccount.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter account");
                    return;
                } else if (pwdPassword.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, "Please enter password");
                    return;
                }

            }
        });
        this.btnReset.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                txtAccount.clear();
                pwdPassword.clear();
            }
        });
        this.registerStage = new RegisterStage(main);
        this.btnSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                registerStage.show();
            }
        });

        this.btnBox = new HBox();
        this.btnBox.setPadding(new Insets(10));
        this.btnBox.setSpacing(10);
        this.btnBox.setAlignment(Pos.TOP_LEFT);
        this.btnBox.getChildren().addAll(btnLogin, btnReset, btnSignUp);
        this.gridPane.add(this.lblAccount, 0, 0);
        this.gridPane.add(this.lblPassword, 0, 1);
        this.gridPane.add(this.txtAccount, 1, 0);
        this.gridPane.add(this.pwdPassword, 1, 1);
        this.gridPane.add(this.btnBox, 1, 2);


        this.vBox = new VBox();
        this.vBox.setPadding(new Insets(10));
        this.vBox.setSpacing(10);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.getChildren().addAll(this.titleBox, this.gridPane);
    }

    private void showAlert(Alert.AlertType alertType, String message) {
        Alert alert = new Alert(alertType);

        alert.setHeaderText(null);
        alert.setContentText(message);

        alert.show();
    }

    public static int getLoginStageWidth() {
        return LOGIN_STAGE_WIDTH;
    }

    public static int getLoginStageHeight() {
        return LOGIN_STAGE_HEIGHT;
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

    public TextField getTxtAccount() {
        return txtAccount;
    }

    public void setTxtAccount(TextField txtAccount) {
        this.txtAccount = txtAccount;
    }

    public PasswordField getPwdPassword() {
        return pwdPassword;
    }

    public void setPwdPassword(PasswordField pwdPassword) {
        this.pwdPassword = pwdPassword;
    }

    public Button getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(Button btnLogin) {
        this.btnLogin = btnLogin;
    }

    public Button getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(Button btnReset) {
        this.btnReset = btnReset;
    }

    public Button getBtnSignUp() {
        return btnSignUp;
    }

    public void setBtnSignUp(Button btnSignUp) {
        this.btnSignUp = btnSignUp;
    }

    public RegisterStage getRegisterStage() {
        return registerStage;
    }

    public void setRegisterStage(RegisterStage registerStage) {
        this.registerStage = registerStage;
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