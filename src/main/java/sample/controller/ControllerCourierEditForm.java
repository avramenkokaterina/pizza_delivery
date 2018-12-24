package sample.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.Customer;
import sample.model.Invoice;
import sample.model.dbworker.GetCourier;
import sample.model.dbworker.GetCustomer;
import sample.model.dbworker.GetInvoice;
import sample.model.dbworker.requests.CustomerDelete;
import sample.model.dbworker.requests.CustomerUpdate;
import sample.model.dbworker.requests.InvoiceDelete;
import sample.model.dbworker.requests.InvoiceUpdate;

import javax.swing.text.html.InlineView;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControllerCourierEditForm {

    @FXML
    private Button docButtonText;

    @FXML
    private TableView<Customer> customersTable;

    @FXML
    private Button updateClient;

    @FXML
    private TableColumn<Invoice, Integer> idInvoice;

    @FXML
    private TextField txtBoxTelephone;

    @FXML
    private TableColumn<Customer, Integer> idCustomer;

    @FXML
    private Button updateInvoice;

    @FXML
    private Button closeBttn;

    @FXML
    private TableView<Invoice> invoiceTable;

    @FXML
    private Tab invoices;

    @FXML
    private TextField datetxtBox;

    @FXML
    private ComboBox<Integer> choiceIDInvoiceUpd;


    @FXML
    private Tab customers;

    @FXML
    private ComboBox<Integer> choiceIDCustomerUpd;

    @FXML
    private Button helpButtonText;

    @FXML
    private Button logoutButton;

    @FXML
    private TableColumn<Customer, String> surnameCustomer;

    @FXML
    private TableColumn<Customer, String> phoneCustomer;

    @FXML
    private Button deleteInvoice;

    @FXML
    private Button creatorButtonText;

    @FXML
    private ComboBox<Integer> choiceIDCustomerDel;

    @FXML
    private Button deleteClient;

    @FXML
    private TableColumn<Customer, String> emailCustomer;

    @FXML
    private TableColumn<Invoice, String> arrivingTime;

    @FXML
    private TableColumn<Invoice, Integer> idPayment;

    @FXML
    private TableColumn<Customer, String> nameCustomer;

    @FXML
    private ComboBox<Integer> choiceIDInvoiceDel;

    @FXML
    private Label name;

    @FXML
    private TableColumn<Invoice, String> status;

    private ObservableList<Customer> resultDataCustomer = FXCollections.observableArrayList();
    private ObservableList<Invoice> resultDataInvoice = FXCollections.observableArrayList();

    private final static String PHONE_FORMAT = "[1-9]{1}[0-9]{5}";

    @FXML
    void customersAction() {
        resultDataCustomer.clear();
        initData();
        for (Customer customer: resultDataCustomer) {
            choiceIDCustomerUpd.getItems().addAll(customer.getIdCustomer());
            choiceIDCustomerDel.getItems().addAll(customer.getIdCustomer());
        }
        idCustomer.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("idCustomer"));
        nameCustomer.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerName"));
        surnameCustomer.setCellValueFactory(new PropertyValueFactory<Customer, String>("customerSurname"));
        phoneCustomer.setCellValueFactory(new PropertyValueFactory<Customer, String>("telephone"));
        emailCustomer.setCellValueFactory(new PropertyValueFactory<Customer, String>("email"));
        customersTable.setItems(resultDataCustomer);
    }

    @FXML
    public void initData(){
        GetCustomer customer = new GetCustomer();
        resultDataCustomer.addAll(customer.getCustomers());

        GetInvoice invoice = new GetInvoice();
        resultDataInvoice.addAll(invoice.getInvoices());
    }

    @FXML
    void updateClientAction() {
        if (!(choiceIDCustomerUpd.getValue() == null) && !(txtBoxTelephone.getText().isEmpty()) &&(txtBoxTelephone.getText().matches(PHONE_FORMAT))) {
            String phone = txtBoxTelephone.getText();
            int idCustomer = choiceIDCustomerUpd.getValue();
            CustomerUpdate customerUpdate = new CustomerUpdate();
            resultDataCustomer.addAll(customerUpdate.getCustomers(idCustomer, phone));
            customersAction();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Некоректно введені дані! Формат телефону [1-9]{1}[0-9]{5}");
            alert.showAndWait();
            datetxtBox.clear();
        }
    }

    @FXML
    void deleteClientAction() {
        if (!(choiceIDCustomerDel.getValue() == null)) {
            int idCustomer = choiceIDCustomerDel.getValue();
            CustomerDelete customerDelete = new CustomerDelete();
            customerDelete.getCustomers(idCustomer);
            GetInvoice getInvoice = new GetInvoice();
            resultDataInvoice.addAll(getInvoice.getInvoices());
            invoicesAction();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Оберіть ID");
            alert.showAndWait();
            datetxtBox.clear();
        }
    }

    private final static String DATE_FORMAT = "[0-9]{2}.[0-9]{2}.[0-9]{4}";

    @FXML
    void invoicesAction() {
        resultDataInvoice.clear();
        initData();
        for (Invoice invoice: resultDataInvoice) {
            choiceIDInvoiceUpd.getItems().addAll(invoice.getIdInvoice());
            choiceIDInvoiceDel.getItems().addAll(invoice.getIdInvoice());
        }
        idInvoice.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("idInvoice"));
        idPayment.setCellValueFactory(new PropertyValueFactory<Invoice, Integer>("idPayment"));
        arrivingTime.setCellValueFactory(new PropertyValueFactory<Invoice, String>("arrivingTime"));
        status.setCellValueFactory(new PropertyValueFactory<Invoice, String>("status"));
        invoiceTable.setItems(resultDataInvoice);
    }

    @FXML
    void deleteInvoiceAction() {
        if (!(choiceIDInvoiceDel.getValue() == null)) {
            int idInvoice = choiceIDInvoiceDel.getValue();
            InvoiceDelete invoiceDelete = new InvoiceDelete();
            invoiceDelete.getInvoices(idInvoice);
            GetInvoice getInvoice = new GetInvoice();
            resultDataInvoice.addAll(getInvoice.getInvoices());
            invoicesAction();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Оберіть ID");
            alert.showAndWait();
            datetxtBox.clear();
        }
    }

    @FXML
    void updateInvoiceAction() {
        if (!(choiceIDInvoiceUpd.getValue() == null) && !(datetxtBox.getText().isEmpty()) &&(datetxtBox.getText().matches(DATE_FORMAT))) {
            String newDate = datetxtBox.getText();
            int idInvoice = choiceIDInvoiceUpd.getValue();
            InvoiceUpdate invoiceUpdate = new InvoiceUpdate();
            invoiceUpdate.getInvoices(idInvoice, newDate);
            GetInvoice getInvoice = new GetInvoice();
            resultDataInvoice.addAll(getInvoice.getInvoices());
            invoicesAction();
        }
        else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Некоректно введені дані! Формат дати dd.mm.yyyy");
            alert.showAndWait();
            datetxtBox.clear();
        }
    }

    @FXML
    private void logoutButtonAction() throws Exception {
        Stage stage = (Stage) logoutButton.getScene().getWindow();
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
    private void creatorClick(){
        File pngFile = new File("sources/report/creator.png");
        if(pngFile.exists()){
            if (Desktop.isDesktopSupported()){
                try
                {
                    Desktop.getDesktop().open(pngFile);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void docClick(){
        File docFile = new File("sources/report/курсова_робота.docx");
        if(docFile.exists()){
            if (Desktop.isDesktopSupported()){
                try
                {
                    Desktop.getDesktop().open(docFile);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void helpClick(){
        File txtFile = new File("sources/report/README.txt");
        if(txtFile.exists()){
            if (Desktop.isDesktopSupported()){
                try
                {
                    Desktop.getDesktop().open(txtFile);
                }
                catch (IOException e)
                {
                    e.printStackTrace();
                }
            }
        }
    }

    @FXML
    private void closeBttnAction() throws Exception{
        Stage stage = (Stage) closeBttn.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/courierForm.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

}
