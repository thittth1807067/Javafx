package stage;

import controller.TransactionController;
import entity.Account;
import entity.Transaction;
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
import javafx.stage.Stage;
import model.AccountModel;
import model.TransactionModel;
import mainThread.Main;



public class TransferStage extends Stage {
    private int amountValue;


    private static final int TRANSFER_STAGE_WIDTH = 500;
    private static final int TRANSFER_STAGE_HEIGHT = 400;
    private VBox vBox;
    private HBox titleBox;
    private GridPane gridPane;
    private HBox btnBox;

    private Label lblTitle;
    private Label lblSenderId;
    private Label lblReceiveId;
    private Label lblAmount;
    private Label lblMessage;

    private TextField txtId;
    private TextField txtSenderId;
    private TextField txtReceiveId;
    private TextField txtAmount;
    private TextField txtMessage;
    private TextField txtCreatedAt;
    private TextField txtUpdatedAt;
    private TextField txtStatus;
    private Button btnTransfer;
    private Button btnCancel;
    private Button btnSearch;

    private Scene scene;
    private Stage stage;
    private Main main;
    private AccountModel model;

    public TransferStage(Main main) {
        this.model = new AccountModel();
        this.main = main;
        initComponent();
        this.scene = new Scene(this.vBox, TRANSFER_STAGE_WIDTH, TRANSFER_STAGE_HEIGHT);
        this.stage = this;
        this.stage.setScene(this.scene);
    }

    private void initComponent() {
        this.titleBox = new HBox();
        this.titleBox.setAlignment(Pos.TOP_LEFT);
        this.titleBox.setSpacing(10);
        this.lblTitle = new Label("Transfer");
        this.lblTitle.setStyle(" -fx-text-fill: #2d0fce;-fx-font: normal bold 18px 'serif' ");
        this.titleBox.getChildren().add(lblTitle);

        this.gridPane = new GridPane();

        this.lblSenderId = new Label("Sender ID");
        this.lblReceiveId = new Label("ReceiveId");
        this.lblAmount = new Label("Amount");
        this.lblMessage = new Label("Message");

        this.txtSenderId = new TextField();
        this.txtReceiveId = new TextField();
        this.btnSearch = new Button("Search");
        this.txtAmount = new TextField(String.valueOf(amountValue));
        this.txtMessage = new TextField();
        this.btnBox = new HBox();
        this.btnTransfer = new Button("Transfer");
        this.btnCancel = new Button("Cancel");
        this.btnBox.getChildren().addAll(this.btnTransfer, this.btnCancel);

        this.gridPane.add(lblSenderId, 0, 0);
        this.gridPane.add(txtSenderId, 1, 0);
        this.gridPane.add(lblReceiveId, 0, 1);
        this.gridPane.add(txtReceiveId, 1, 1);
        this.gridPane.add(btnSearch, 3, 1);
        this.gridPane.add(lblAmount, 0, 2);
        this.gridPane.add(txtAmount, 1, 2);
        this.gridPane.add(lblMessage, 0, 3);
        this.gridPane.add(txtMessage, 1, 3);
        this.gridPane.add(this.btnBox, 1, 4);
        this.gridPane.setPadding(new Insets(10));
        this.gridPane.setHgap(10);
        this.gridPane.setVgap(10);

        this.vBox = new VBox();
        this.vBox.setSpacing(10);
        this.vBox.setAlignment(Pos.CENTER);
        this.vBox.setPadding(new Insets(10));
        this.vBox.getChildren().addAll(titleBox, gridPane);

        btnSearch.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                Account transaction = model.search(Integer.parseInt(txtSenderId.getText()));
                if (transaction.equals(txtSenderId)) {
                    main.setUserID(String.valueOf(transaction.getUserID()));
                    System.out.println("it's me!");
                }
            }
        });

        btnCancel.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                close();
            }
        });

        btnTransfer.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                TransactionController transactionController = new TransactionController();
                Transaction transaction = new Transaction(
                        Integer.parseInt(txtSenderId.getText()),
                        Integer.parseInt(txtReceiveId.getText()),
                        Integer.parseInt(txtAmount.getText()),
                        txtMessage.getText()
                );
                transactionController.create(transaction);
                txtSenderId.clear();
                txtReceiveId.clear();
                txtAmount.clear();
                txtMessage.clear();
                stage.close();
            }
        });


    }

    public static int getTransferStageWidth() {
        return TRANSFER_STAGE_WIDTH;
    }

    public static int getTransferStageHeight() {
        return TRANSFER_STAGE_HEIGHT;
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


    public Label getLblSenderId() {
        return lblSenderId;
    }

    public void setLblSenderId(Label lblSenderId) {
        this.lblSenderId = lblSenderId;
    }

    public Label getLblReceiveId() {
        return lblReceiveId;
    }

    public void setLblReceiveId(Label lblReceiveId) {
        this.lblReceiveId = lblReceiveId;
    }

    public Label getLblAmount() {
        return lblAmount;
    }

    public void setLblAmount(Label lblAmount) {
        this.lblAmount = lblAmount;
    }

    public Label getLblMessage() {
        return lblMessage;
    }

    public void setLblMessage(Label lblMessage) {
        this.lblMessage = lblMessage;
    }


    public TextField getTxtId() {
        return txtId;
    }

    public void setTxtId(TextField txtId) {
        this.txtId = txtId;
    }

    public TextField getTxtSenderId() {
        return txtSenderId;
    }

    public void setTxtSenderId(TextField txtSenderId) {
        this.txtSenderId = txtSenderId;
    }

    public TextField getTxtReceiveId() {
        return txtReceiveId;
    }

    public void setTxtReceiveId(TextField txtReceiveId) {
        this.txtReceiveId = txtReceiveId;
    }

    public TextField getTxtAmount() {
        return txtAmount;
    }

    public void setTxtAmount(TextField txtAmount) {
        this.txtAmount = txtAmount;
    }

    public TextField getTxtMessage() {
        return txtMessage;
    }

    public void setTxtMessage(TextField txtMessage) {
        this.txtMessage = txtMessage;
    }

    public TextField getTxtCreatedAt() {
        return txtCreatedAt;
    }

    public void setTxtCreatedAt(TextField txtCreatedAt) {
        this.txtCreatedAt = txtCreatedAt;
    }

    public TextField getTxtUpdatedAt() {
        return txtUpdatedAt;
    }

    public void setTxtUpdatedAt(TextField txtUpdatedAt) {
        this.txtUpdatedAt = txtUpdatedAt;
    }

    public TextField getTxtStatus() {
        return txtStatus;
    }

    public void setTxtStatus(TextField txtStatus) {
        this.txtStatus = txtStatus;
    }

    public Button getBtnTransfer() {
        return btnTransfer;
    }

    public void setBtnTransfer(Button btnTransfer) {
        this.btnTransfer = btnTransfer;
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
}