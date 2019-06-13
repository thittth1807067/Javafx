package stage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.AccountModel;
import mainThread.Main;

public class AccountStage extends Stage {

    private String accountName;
    private int accountBalance;

    private HBox titleBox;
    private VBox menuBox;
    private VBox categoryBox;
    private HBox btnBox;
    private GridPane gridPaneContent;

    private Label lblTitle;
    private Label lblAcount;
    private Label lblBalance;
    private Label lblAccountName;
    private Label lblBalanceValue;
    private Button btnWithdraw;
    private Button btnDeposit;


    private Label lblhome;
    private Label lblLogin;
    private Label lblRegister;
    private Label lblWithdraw;
    private Label lblDeposit;

    private Scene scene;
    private Scene newScene;
    private Stage stage;
    private BorderPane borderPane;
    private WithdrawStage withdrawStage;
    private DepositStage depositStage;
    private LoginStage loginStage;
    private RegisterStage registerStage;
    private AccountModel model;
    private AccountStage accountStage;
    private Main main;//luư địa chỉ bộ nhớ\


    private static boolean isLoggedIn = false;
    private static boolean isRegistered = false;

    public AccountStage(Main main) {
        this.model = new AccountModel();
        this.main = main;
        this.initComponent();
        this.scene = new Scene(this.borderPane, 400, 200);
        this.stage = this;
        this.stage.setScene(this.scene);

    }


    private void initComponent() {

        this.titleBox = new HBox();
        this.titleBox.setStyle(" -fx-background-color: #232252;");
        this.lblTitle = new Label(" Hero Bank");
        this.lblTitle.setStyle(" -fx-text-fill: white;-fx-font: normal bold 18px 'serif' ");
        this.titleBox.getChildren().add(lblTitle);
        this.titleBox.setPadding(new Insets(10, 10, 10, 40));

        this.menuBox = new VBox();
        this.menuBox.setStyle("-fx-background-color: rgba(192,202,203,0.44);-fx-font: normal bold 14px 'serif'");
        this.lblLogin = new Label("Login");
        this.lblLogin.setPadding(new Insets(0, 0, 10, 0));
        this.lblRegister = new Label("Register");
        this.lblRegister.setPadding(new Insets(0, 0, 10, 0));
        this.menuBox.setPadding(new Insets(10));

        this.menuBox.getChildren().addAll(this.lblLogin, this.lblRegister);


        this.categoryBox = new VBox();
        this.categoryBox.setStyle("-fx-background-color: #fffdfd;-fx-font: normal bold 20px 'serif'");
        this.lblhome = new Label("Welcome To Spring Hero Bank");
        this.categoryBox.setPadding(new Insets(50, 10, 10, 30));

        this.categoryBox.getChildren().add(lblhome);


        this.borderPane = new BorderPane();
        borderPane.setTop(titleBox);
        borderPane.setLeft(menuBox);
        borderPane.setCenter(categoryBox);

        this.loginStage = new LoginStage(main);
        this.registerStage = new RegisterStage(main);


        lblLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
//                main.setScene(newScene);
                loginStage.show();
            }
        });

        lblRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                registerStage.show();
            }
        });

    }

    public VBox getMenuBox() {
        return menuBox;
    }

    public void setMenuBox(VBox menuBox) {
        this.menuBox = menuBox;
    }


    public Scene getNewScene() {
        return newScene;
    }

    public void setNewScene(Scene newScene) {
        this.newScene = newScene;
    }

    public BorderPane getBorderPane() {
        return borderPane;
    }

    public void setBorderPane(BorderPane borderPane) {
        this.borderPane = borderPane;
    }


    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public HBox getTitleBox() {
        return titleBox;
    }

    public void setTitleBox(HBox titleBox) {
        this.titleBox = titleBox;
    }

    public HBox getBtnBox() {
        return btnBox;
    }

    public void setBtnBox(HBox btnBox) {
        this.btnBox = btnBox;
    }

    public GridPane getGridPaneContent() {
        return gridPaneContent;
    }

    public void setGridPaneContent(GridPane gridPaneContent) {
        this.gridPaneContent = gridPaneContent;
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
    }

    public Label getLblAcount() {
        return lblAcount;
    }

    public void setLblAcount(Label lblAcount) {
        this.lblAcount = lblAcount;
    }

    public Label getLblBalance() {
        return lblBalance;
    }

    public void setLblBalance(Label lblBalance) {
        this.lblBalance = lblBalance;
    }

    public Label getLblAccountName() {
        return lblAccountName;
    }

    public void setLblAccountName(Label lblAccountName) {
        this.lblAccountName = lblAccountName;
    }

    public Label getLblBalanceValue() {
        return lblBalanceValue;
    }

    public void setLblBalanceValue(Label lblBalanceValue) {
        this.lblBalanceValue = lblBalanceValue;
    }

    public Button getBtnWithdraw() {
        return btnWithdraw;
    }

    public void setBtnWithdraw(Button btnWithdraw) {
        this.btnWithdraw = btnWithdraw;
    }

    public Button getBtnDeposit() {
        return btnDeposit;
    }

    public void setBtnDeposit(Button btnDeposit) {
        this.btnDeposit = btnDeposit;
    }


    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public WithdrawStage getWithdrawStage() {
        return withdrawStage;
    }

    public void setWithdrawStage(WithdrawStage withdrawStage) {
        this.withdrawStage = withdrawStage;
    }

    public DepositStage getDepositStage() {
        return depositStage;
    }

    public void setDepositStage(DepositStage depositStage) {
        this.depositStage = depositStage;
    }

    public LoginStage getLoginStage() {
        return loginStage;
    }

    public void setLoginStage(LoginStage loginStage) {
        this.loginStage = loginStage;
    }

    public RegisterStage getRegisterStage() {
        return registerStage;
    }

    public void setRegisterStage(RegisterStage registerStage) {
        this.registerStage = registerStage;
    }

    public AccountModel getModel() {
        return model;
    }

    public void setModel(AccountModel model) {
        this.model = model;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        AccountStage.isLoggedIn = isLoggedIn;
    }

    public static boolean isIsRegistered() {
        return isRegistered;
    }

    public static void setIsRegistered(boolean isRegistered) {
        AccountStage.isRegistered = isRegistered;
    }


    public VBox getCategoryBox() {
        return categoryBox;
    }

    public void setCategoryBox(VBox categoryBox) {
        this.categoryBox = categoryBox;
    }

    public AccountStage getAccountStage() {
        return accountStage;
    }

    public void setAccountStage(AccountStage accountStage) {
        this.accountStage = accountStage;
    }

    public Label getLblhome() {
        return lblhome;
    }

    public void setLblhome(Label lblhome) {
        this.lblhome = lblhome;
    }

    public Label getLblLogin() {
        return lblLogin;
    }

    public void setLblLogin(Label lblLogin) {
        this.lblLogin = lblLogin;
    }

    public Label getLblRegister() {
        return lblRegister;
    }

    public void setLblRegister(Label lblRegister) {
        this.lblRegister = lblRegister;
    }

    public Label getLblWithdraw() {
        return lblWithdraw;
    }

    public void setLblWithdraw(Label lblWithdraw) {
        this.lblWithdraw = lblWithdraw;
    }

    public Label getLblDeposit() {
        return lblDeposit;
    }

    public void setLblDeposit(Label lblDeposit) {
        this.lblDeposit = lblDeposit;
    }
}