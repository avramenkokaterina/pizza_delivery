package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Customer;
import sample.model.dbworker.GetCustomer;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class ControllerLoginUserForm {

    @FXML
    private TextField numberEnter;

    @FXML
    private TextField loginEnter;

    @FXML
    private Button exitBttn;

    @FXML
    private TextField surnameEnter;

    @FXML
    private Button logInButton;

    @FXML
    private Button signInButton;

    private Customer customer;

    public Customer getCustomer() {
        return customer;
    }

    @FXML
    public void initialize() {
    }

    @FXML
    void loginAction() throws Exception {
        String name;
        String surname;
        String phone;
        Customer existingCustomer = new Customer();
        GetCustomer getCustomer = new GetCustomer();
        List<Customer> customersList = new ArrayList<>();
        customersList = getCustomer.getCustomers();
        for (Customer customer : customersList) {
            name = loginEnter.getText();
            surname = surnameEnter.getText();
            phone = numberEnter.getText();
            if (name.equals(customer.getCustomerName()) && surname.equals((customer.getCustomerSurname())) && phone.equals(customer.getTelephone())) {
                existingCustomer.setIdCustomer(customer.getIdCustomer());
                existingCustomer.setCustomerName(customer.getCustomerName());
                existingCustomer.setCustomerSurname(customer.getCustomerSurname());
                existingCustomer.setCity(customer.getCity());
                existingCustomer.setStreet(customer.getStreet());
                existingCustomer.setBuilding(customer.getBuilding());
                existingCustomer.setTelephone(customer.getTelephone());
                existingCustomer.setEmail(customer.getEmail());
                Stage stage = (Stage) logInButton.getScene().getWindow();
                stage.hide();
                URL url = new File("src/main/java/sample/view/orderForm.fxml").toURI().toURL();
                Parent root = FXMLLoader.load(url);
                Stage newStage = new Stage();
                newStage.setScene(new Scene(root));
                newStage.initStyle(StageStyle.UNDECORATED);
                newStage.showAndWait();
                stage.close();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Помилка");
                alert.setHeaderText(null);
                alert.setContentText("Ваші дані не знайдено. \nВведіть свої дані у наступній формі.");
                alert.showAndWait();
                signinAction();
            }
        }

    }

    @FXML
    void signinAction() throws Exception {
        Stage stage = (Stage) signInButton.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/orderForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

    @FXML
    void closeButtonAction() throws Exception {
        Stage stage = (Stage) exitBttn.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/pizzaForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }
}
