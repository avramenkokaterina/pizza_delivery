package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.dbworker.DBWorker;
import sample.model.dbworker.requests.CourierFormRequestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerCourierForm {

    private ObservableList<CourierFormRequestResult> resultData = FXCollections.observableArrayList();

    @FXML
    private Button docButtonText;

    @FXML
    private Button editBttn;

    @FXML
    private TableColumn<CourierFormRequestResult, Integer> quantity;

    @FXML
    private Button creatorButtonText;

    @FXML
    private TableColumn<CourierFormRequestResult, Integer> idInvoice;

    @FXML
    private TableColumn<CourierFormRequestResult, String> paymentTypeName;

    @FXML
    private Button showReportBttn;

    @FXML
    private TableColumn<CourierFormRequestResult, Integer> idCustomer;

    @FXML
    private TableColumn<CourierFormRequestResult, String> arrivingTime;

    @FXML
    private TableColumn<CourierFormRequestResult, Integer> idPayment;

    @FXML
    private Button logOutButton;

    @FXML
    private TableColumn<CourierFormRequestResult, String> courier;

    @FXML
    private Label name;

    @FXML
    private TableColumn<CourierFormRequestResult, String> purchaseTime;

    @FXML
    private Button exitBttn;

    @FXML
    private Button helpButtonText;

    @FXML
    private TableColumn<CourierFormRequestResult, String> pizzaName;

    @FXML
    private TableView<CourierFormRequestResult> table;

    @FXML
    private TableColumn<CourierFormRequestResult, String> status;

    @FXML
    private void logoutButtonAction() throws Exception {
        Stage stage = (Stage) logOutButton.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

    @FXML
    private void creatorClick() {
        File pngFile = new File("sources/report/creator.png");
        if (pngFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(pngFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void docClick() {
        File docFile = new File("sources/report/курсова_робота.docx");
        if (docFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(docFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void helpClick() {
        File txtFile = new File("sources/report/README.txt");
        if (txtFile.exists()) {
            if (Desktop.isDesktopSupported()) {
                try {
                    Desktop.getDesktop().open(txtFile);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) exitBttn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void editBttnAction() throws Exception {
        Stage stage = (Stage) editBttn.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/courierEditForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

    @FXML
    private void reportBttnAction() throws Exception {
        Stage stage = (Stage) showReportBttn.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/courierReportForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

    @FXML
    public void initialize()  throws Exception {
        initData();

        idInvoice.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, Integer>("idInvoice"));
        idPayment.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, Integer>("idPayment"));
        paymentTypeName.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("paymentTypeName"));
        pizzaName.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("pizzaName"));
        quantity.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, Integer>("quantity"));
        idCustomer.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, Integer>("idCustomer"));
        courier.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("courier"));
        purchaseTime.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("purchaseTime"));
        arrivingTime.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("arrivingTime"));
        status.setCellValueFactory(new PropertyValueFactory<CourierFormRequestResult, String>("status"));

        table.setItems(resultData);
    }

    private void initData() {
//        Courier currentCourier;
//        ControllerLoginForm loginForm = new ControllerLoginForm();
//        currentCourier = loginForm.getExistingCourier();
//        String courierNameAndSurname = currentCourier.getNameCourier() +" " + currentCourier.getSurnameCourier();
//        name.setText(courierNameAndSurname);

        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT i.id_invoice , i.id_payment ,pt.PAYMENT_TYPE_NAME, piz.pizza_name , idet.quantity , c.id_customer , " +
                "cr.courier_name || cr.courier_surname , i.purchase_time, i.arriving_time , i.status " +
                "FROM (invoice i JOIN payment p ON i.id_payment = p.id_payment " +
                "JOIN invoice_detail idet ON i.id_invoice = idet.id_invoice " +
                "JOIN pizza piz ON idet.id_pizza = piz.id_pizza  " +
                "JOIN customer c ON i.id_customer = c.id_customer " +
                "JOIN payment_type pt ON p.id_type = pt.id_type " +
                "JOIN courier cr ON i.id_courier=cr.id_courier) " +
                "ORDER BY i.id_invoice";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while(resultSet.next()){
                CourierFormRequestResult result = new CourierFormRequestResult();
                result.setIdInvoice(resultSet.getInt(1));
                result.setIdPayment(resultSet.getInt(2));
                result.setPaymentTypeName(resultSet.getString(3));
                result.setPizzaName(resultSet.getString(4));
                result.setQuantity(resultSet.getInt(5));
                result.setIdCustomer(resultSet.getInt(6));
                result.setCourier(resultSet.getString(7));
                result.setPurchaseTime(resultSet.getString(8));
                result.setArrivingTime(resultSet.getString(9));
                result.setStatus(resultSet.getString(10));
                resultData.add(result);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }


}
