package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerOrderForm implements Initializable {
    @FXML
    private Button docButtonText;

    @FXML
    private DatePicker date;

    @FXML
    private Button quantitySubtr;

    @FXML
    private Label totalPrice;

    @FXML
    private ComboBox<?> city;

    @FXML
    private TextField building;

    @FXML
    private Label numberlbl;

    @FXML
    private TextField street;

    @FXML
    private TextField surname;

    @FXML
    private ComboBox<?> payment;

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
    private ComboBox<?> size;

    @FXML
    private TextField name;

    @FXML
    private Button exitBttn;

    @FXML
    private TextField time;

    @FXML
    private Label pizzaPrice;

    @FXML
    private Button orderButtonFinal;


    @FXML
    public void initialize(URL Location, ResourceBundle resourceBundle) {
        city.getItems().removeAll(city.getItems());
        //city.getItems().addAll("Київ", "Бровари");
        payment.getItems().removeAll(payment.getItems());
        // payment.getItems().addAll("Готівкою кур'єру", "Картою кур'єру");
    }

}
