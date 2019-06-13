package stage;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import mainThread.Main;


public class DepositStage extends Stage {
    private int amountValue;
    private int accountBalance;

    private Main main;
    private GridPane gridPane;
    private VBox vBox;
    private HBox titleBox;
    private HBox btnBox;

    private Label lbltitle;
    private Label lblAmount;
    private TextField txtAmountValue;
    private Button btnSubmit;
    private Button btnClose;


    private Scene scene;


    public DepositStage(Main main) {
        this.main = main;
        initComponent();
    }
//    public DepositStage(Label accountStatus){
//        this.accountStatus = accountStatus;
//        initComponent();
//    }

    public int getAmountValue() {
        return amountValue;
    }

    public void setAmountValue(int amountValue) {
        this.amountValue = amountValue;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public GridPane getGridPane() {
        return gridPane;
    }

    public void setGridPane(GridPane gridPane) {
        this.gridPane = gridPane;
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

    public HBox getBtnBox() {
        return btnBox;
    }

    public void setBtnBox(HBox btnBox) {
        this.btnBox = btnBox;
    }

    public Label getLbltitle() {
        return lbltitle;
    }

    public void setLbltitle(Label lbltitle) {
        this.lbltitle = lbltitle;
    }

    public Label getLblAmount() {
        return lblAmount;
    }

    public void setLblAmount(Label lblAmount) {
        this.lblAmount = lblAmount;
    }

    public TextField getTxtAmountValue() {
        return txtAmountValue;
    }

    public void setTxtAmountValue(TextField txtAmountValue) {
        this.txtAmountValue = txtAmountValue;
    }


    public Button getBtnSubmit() {
        return btnSubmit;
    }

    public void setBtnSubmit(Button btnSubmit) {
        this.btnSubmit = btnSubmit;
    }

    public Button getBtnClose() {
        return btnClose;
    }

    public void setBtnClose(Button btnClose) {
        this.btnClose = btnClose;
    }


    private void initComponent() {
        this.initModality(Modality.APPLICATION_MODAL);
        this.vBox = new VBox();

        this.titleBox = new HBox();
        this.lbltitle = new Label("Deposit");
        this.lbltitle.setFont(Font.font(18));
        this.titleBox.getChildren().add(lbltitle);
        this.titleBox.setAlignment(Pos.CENTER);
        this.titleBox.setSpacing(10);

        this.gridPane = new GridPane();
        this.lblAmount = new Label("Amount");
        this.txtAmountValue = new TextField(String.valueOf(amountValue));
        this.gridPane.add(this.lblAmount, 0, 0);
        this.gridPane.add(this.txtAmountValue, 1, 0);
        this.gridPane.setAlignment(Pos.CENTER);
        this.gridPane.setPadding(new Insets(10, 10, 10, 10));
        this.gridPane.setVgap(10);
        this.gridPane.setHgap(10);

        this.btnBox = new HBox();
        this.btnSubmit = new Button("Submit");
        this.btnClose = new Button("Close");
        this.btnBox.getChildren().addAll(this.btnSubmit, this.btnClose);
        this.btnBox.setAlignment(Pos.CENTER);
        this.btnBox.setSpacing(10);

        this.vBox.getChildren().addAll(this.titleBox, this.gridPane, this.btnBox);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setSpacing(30);
        this.vBox.setPadding(new Insets(10));

        this.scene = new Scene(this.vBox, 600, 300);
        this.setScene(this.scene);

        btnSubmit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                int accountValue = 0;
                try {
                    accountValue = Integer.parseInt(txtAmountValue.getText());
                    int balance = main.getAccountBalance() + accountValue;
                    main.getLblBalanceValue().setText(String.valueOf(balance));
                    main.setAccountBalance(balance);
                    txtAmountValue.clear();
                    close();
                } catch (NumberFormatException ex) {
                    ex.printStackTrace();
                }

            }
        });
        btnClose.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
//                Boolean answer = ConfirmStage.display("Title", "Sure you want to exit?");
//                if (answer) close();
                close();
            }
        });

    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(int accountBalance) {
        this.accountBalance = accountBalance;
    }

}