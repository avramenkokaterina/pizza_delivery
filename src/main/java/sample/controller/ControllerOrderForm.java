package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Customer;
import sample.model.Pizza;
import sample.model.dbworker.DBWorker;
import sample.model.dbworker.GetCustomer;
import sample.model.dbworker.GetInvoice;
import sample.model.dbworker.requests.PizzaFormRequestResult;
import sample.state.PizzaState;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class ControllerOrderForm {
    @FXML
    private Button docButtonText;

    @FXML
    private DatePicker date;

    @FXML
    private Button quantitySubtr;

    @FXML
    private Label totalPrice;

    @FXML
    private ComboBox<String> city;

    @FXML
    private TextField building;

    @FXML
    private Label numberlbl;

    @FXML
    private TextField street;

    @FXML
    private TextField surname;

    @FXML
    private ComboBox<String> payment;

    @FXML
    private Button quantityAdd;

    @FXML
    private Button helpButtonText;

    @FXML
    private Label totalPricelbl;

    @FXML
    private Button logInButton;

    @FXML
    private Button orderButton;

    @FXML
    private TextField email;

    @FXML
    private ImageView image;

    @FXML
    private TextField appartment;

    @FXML
    private Button creatorButtonText;

    @FXML
    private TextField telephone;

    @FXML
    private Label descr;

    @FXML
    private Label namePizza;

    @FXML
    private ComboBox<String> size;

    @FXML
    private TextField name;

    @FXML
    private Button exitBttn;


    @FXML
    private Label pizzaPrice;

    @FXML
    private Button orderButtonFinal;


    @FXML
    private Label quantitylbl;

    @FXML
    void loginButtonAction() throws Exception {
        Stage stage = (Stage) logInButton.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/loginForm.fxml").toURI().toURL();
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
    void orderAction() throws Exception {
        if (street.getText().isEmpty() && building.getText().isEmpty() &&
                appartment.getText().isEmpty() && name.getText().isEmpty() &&
                surname.getText().isEmpty() && telephone.getText().isEmpty() && email.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Заповніть усі поля!");
            alert.showAndWait();
            street.clear();
            building.clear();
            appartment.clear();
            name.clear();
            surname.clear();
            telephone.clear();
            email.clear();
        } else {

            createCustomer();
            //createInvoice(16);

            Stage stage = (Stage) orderButton.getScene().getWindow();
            stage.hide();
            URL url = new File("src/main/java/sample/view/orderSuccess.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.showAndWait();
            stage.close();
        }
    }

    private void createCustomer() {
        GetCustomer getterCustomer = new GetCustomer();
        int idCustomer = getterCustomer.getCustomers().size() + 1;
        String customerName = name.getText();
        String customerSurname = surname.getText();
        String customerCity = city.getValue();
        String customerStreet = street.getText();
        int customerBuilding = Integer.parseInt(building.getText());
        String customerPhone = telephone.getText();
        String customerEmail = email.getText();

        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "Insert into CUSTOMER (ID_CUSTOMER,CUSTOMER_NAME,CUSTOMER_SURNAME,CITY,STREET,BUILDING," +
                "TELEPHONE,E_MAIL) \n " +
                "values ('" + idCustomer + "', '" + customerName + "', '" + customerSurname +
                "', '" + customerCity + "', '" + customerStreet + "', '" + customerBuilding + "', '" + customerPhone +
                "', '" + customerEmail + "')";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    private void createInvoice(int idCustomer) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        Random random = new Random();
        GetInvoice getterInvoice = new GetInvoice();
        int idInvoice = getterInvoice.getInvoices().size() + 1;
        int idPayment = idInvoice;

        int idCourier = random.nextInt(5) + 1 ;
        String purchaseTime = date.getValue().format(formatter);
        String arrivingTime = purchaseTime;
        String status = "не завершено";

        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "Insert into INVOICE (ID_INVOICE,ID_PAYMENT,ID_CUSTOMER,ID_COURIER,PURCHASE_TIME,ARRIVING_TIME,STATUS)  \n " +
                "values ('" + idInvoice + "', '" + idPayment + "', '" + idCustomer +
                "', '" + idCourier + "', '" + purchaseTime + "', '" + arrivingTime + "', '" + status + "')";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void OrderButtonFinalAction() throws Exception {
        orderAction();
    }

    @FXML
    void quantitySubtrAction() {
        int quantity = Integer.parseInt(quantitylbl.getText());
        if (quantity == 1) {
            quantitylbl.setText("1");
            numberlbl.setText("1");
        } else {
            quantitylbl.setText(String.valueOf(quantity - 1));
            numberlbl.setText(String.valueOf(quantity - 1));
        }
    }

    @FXML
    void quantityAddAction() {
        int quantity = Integer.parseInt(quantitylbl.getText());
        quantitylbl.setText(String.valueOf(quantity + 1));
        numberlbl.setText(String.valueOf(quantity + 1));
    }

    @FXML
    public void initialize() {

        PizzaFormRequestResult currentPizza;
        currentPizza = PizzaState.getInstance().getPizza();
        image.setImage(currentPizza.getImage());
        namePizza.setText(currentPizza.getPizzaName());
        descr.setText(currentPizza.getIngr());
        pizzaPrice.setText(String.valueOf(currentPizza.getPrice()));

        int msize = 50;
        int lsize = 100;

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.mm.yyyy");
        numberlbl.setText("1");
        quantitylbl.setText("1");
        city.getItems().removeAll(city.getItems());
        city.getItems().addAll("Київ", "Бровари");
        city.setValue("Київ");
        payment.getItems().removeAll(payment.getItems());
        payment.getItems().addAll("Готівкою кур'єру", "Картою кур'єру");
        payment.setValue("Готівкою кур'єру");
        size.getItems().removeAll(size.getItems());
        size.getItems().addAll("S", "M", "L");
        size.setValue("L");
        date.setValue(LocalDate.now());

        if (size.getValue().equals("S")){
            pizzaPrice.setText(String.valueOf(currentPizza.getPrice()));
            int tempPrice = currentPizza.getPrice() * Integer.parseInt(quantitylbl.getText());
            totalPricelbl.setText(String.valueOf(tempPrice));
            totalPrice.setText(pizzaPrice.getText());
        } else {
            if (size.getValue().equals("M")){
                pizzaPrice.setText(String.valueOf(msize + currentPizza.getPrice()));
                int tempPrice = (msize + currentPizza.getPrice()) * Integer.parseInt(quantitylbl.getText());
                totalPricelbl.setText(String.valueOf(tempPrice));
                totalPrice.setText(pizzaPrice.getText());
            }
            else if (size.getValue().equals("L")){
                pizzaPrice.setText(String.valueOf(lsize + currentPizza.getPrice()));
                int tempPrice = (lsize + currentPizza.getPrice()) * Integer.parseInt(quantitylbl.getText());
                totalPricelbl.setText(String.valueOf(tempPrice));
                totalPrice.setText(pizzaPrice.getText());
            }
        }
    }

}
