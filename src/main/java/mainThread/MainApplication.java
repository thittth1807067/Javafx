package mainThread;

import entity.Account;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import stage.*;

import javax.swing.*;

public class MainApplication extends Application {

    private String accountName;

    private VBox vBox;
    private HBox titleBox;
    private VBox mainBox;
    private HBox hBox;
    private VBox categoryBox;

    private GridPane gridPaneContent;
    private Label lblAcount;
    private Label lblBalance;
    private Label lblAccountName;
    private Label lblBalanceValue;
    private Label lblTitle;
    private Label lblhome;
    private Label lblLogin;
    private Label lblRegister;
    private Label lblWithdraw;
    private Label lblDeposit;
    private HBox btnBox;


    private Pane pane;
    private Scene scene;
    private Stage stage;
    private LoginStage loginStage;
    private RegisterStage registerStage;
    private WithdrawStage withdrawStage;
    private DepositStage depositStage;


    private MainApplication mainApplication;
    private int accountBalance;

    private static boolean isLoggedIn = false;
    private Button btnWithdraw;
    private Button btnDeposit;
    private Account account;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.mainApplication = this;
        this.stage = primaryStage;
        initComponent();


        if (isLoggedIn) {
            // show stage.
            this.stage.show();

        } else {
            this.account = new Account(this);
            this.account.show();

        }

        this.scene = new Scene(this.vBox, 500, 200);
        this.stage.setScene(this.scene);

    }


    private void initComponent() {
        this.vBox = new VBox();

        this.titleBox = new HBox();
        this.lblTitle = new Label("Spring Hero Bank");
        this.lblTitle.setFont(Font.font(18));
        this.lblTitle.setTextFill(Color.web("#ff0cb4"));
        this.titleBox.getChildren().add(lblTitle);
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.setSpacing(10);

        this.gridPaneContent = new GridPane();
        this.lblAcount = new Label("Account:");
        this.lblBalance = new Label("Balance:");
        this.lblAccountName = new Label(this.accountName);
        this.lblBalanceValue = new Label(String.valueOf(this.accountBalance));
        this.gridPaneContent.add(this.lblAcount, 0, 0);
        this.gridPaneContent.add(this.lblAccountName, 1, 0);
        this.gridPaneContent.add(this.lblBalance, 0, 1);
        this.gridPaneContent.add(this.lblBalanceValue, 1, 1);
        this.gridPaneContent.setAlignment(Pos.CENTER);
        this.gridPaneContent.setPadding(new Insets(10));
        this.gridPaneContent.setVgap(10);
        this.gridPaneContent.setHgap(10);
        this.btnBox = new HBox();
        this.btnWithdraw = new Button("Withdraw");
        this.btnDeposit = new Button("Deposit");
        this.btnBox.getChildren().addAll(this.btnWithdraw, this.btnDeposit);
        this.btnBox.setAlignment(Pos.CENTER);
        this.btnBox.setSpacing(10);
        this.gridPaneContent.add(btnBox, 1, 2);


        this.categoryBox = new VBox();
        this.lblLogin = new Label("Login");
        this.lblRegister = new Label("Register");
        this.lblWithdraw = new Label("Withdraw");
        this.lblDeposit = new Label("Deposit");
        this.categoryBox.setAlignment(Pos.TOP_LEFT);
        this.categoryBox.setSpacing(10);
        this.categoryBox.setPadding(new Insets(-20, 0, 0, 10));
        this.categoryBox.getChildren().addAll(this.lblLogin, this.lblRegister, this.lblWithdraw, this.lblDeposit);

        this.mainBox = new VBox();
        this.mainBox.setPadding(new Insets(0));
        this.mainBox.setAlignment(Pos.CENTER);
        this.mainBox.getChildren().addAll(this.gridPaneContent, this.categoryBox);

        this.vBox.getChildren().addAll(this.titleBox, this.mainBox);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(30);
        this.vBox.setPadding(new Insets(10, 10, 10, 10));


        this.withdrawStage = new WithdrawStage(mainApplication);
        this.depositStage = new DepositStage(mainApplication);

        btnDeposit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                depositStage.showAndWait();
            }
        });

        btnWithdraw.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                depositStage.showAndWait();
            }
        });

        this.loginStage = new LoginStage(mainApplication);
        this.registerStage = new RegisterStage(mainApplication);
        this.withdrawStage = new WithdrawStage(mainApplication);
        this.depositStage = new DepositStage(mainApplication);
        lblLogin.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                loginStage.show();
            }
        });

        lblRegister.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                registerStage.show();
            }
        });

        lblWithdraw.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                withdrawStage.show();
            }
        });

        lblDeposit.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                depositStage.show();
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
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

    public HBox gethBox() {
        return hBox;
    }

    public void sethBox(HBox hBox) {
        this.hBox = hBox;
    }

    public VBox getCategoryBox() {
        return categoryBox;
    }

    public void setCategoryBox(VBox categoryBox) {
        this.categoryBox = categoryBox;
    }

    public Label getLblTitle() {
        return lblTitle;
    }

    public void setLblTitle(Label lblTitle) {
        this.lblTitle = lblTitle;
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

    public Scene getScene() {
        return scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public MainApplication getMain() {
        return mainApplication;
    }

    public void setMain(MainApplication mainApplication) {
        this.mainApplication = mainApplication;
    }

    public VBox getMainBox() {
        return mainBox;
    }

    public void setMainBox(VBox mainBox) {
        this.mainBox = mainBox;
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

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

    public Label getLblBalanceValue() {
        return lblBalanceValue;
    }

    public GridPane getGridPaneContent() {
        return gridPaneContent;
    }

    public void setGridPaneContent(GridPane gridPaneContent) {
        this.gridPaneContent = gridPaneContent;
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

    public HBox getBtnBox() {
        return btnBox;
    }

    public void setBtnBox(HBox btnBox) {
        this.btnBox = btnBox;
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

    public void setLblBalanceValue(Label lblBalanceValue) {
        this.lblBalanceValue = lblBalanceValue;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName ( String accountName) {
        this.accountName = accountName;
    }

    public Label getLblAccountName() {
        return lblAccountName;
    }

    public void setLblAccountName(Label lblAccountName) {
        this.lblAccountName = lblAccountName;
    }

    public Pane getPane() {
        return pane;
    }

    public void setPane(Pane pane) {
        this.pane = pane;
    }

    public static boolean isIsLoggedIn() {
        return isLoggedIn;
    }

    public static void setIsLoggedIn(boolean isLoggedIn) {
        MainApplication.isLoggedIn = isLoggedIn;
    }


}