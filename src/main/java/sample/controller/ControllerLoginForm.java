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
import sample.model.Courier;
import sample.model.dbworker.GetCourier;

import java.io.File;
import java.net.URL;
import java.util.List;

public class ControllerLoginForm {

    @FXML
    private PasswordField passwordEnter;

    @FXML
    private Button closeButton;

    @FXML
    private TextField loginEnter;

    @FXML
    private Button logInButton;

    private Courier existingCourier;

    public ControllerLoginForm()throws Exception{
        existingCourier = new Courier();
    }

    public Courier getExistingCourier(){
        return existingCourier;
    }

    @FXML
    void logInButtonAction() throws Exception{
        if (!loginEnter.getText().isEmpty() || !passwordEnter.getText().isEmpty()){
            String login;
            String password;

            GetCourier getCourier = new GetCourier();
            List<Courier> couriers = getCourier.getCourier();
            for (Courier courier: couriers){
                login = loginEnter.getText();
                password = passwordEnter.getText();
                if (login.equals(courier.getLogin()) && password.equals(courier.getPassword())){
                    existingCourier.setLogin(courier.getLogin());
                    existingCourier.setPassword(courier.getPassword());
                    existingCourier.setIdCourier(courier.getIdCourier());
                    existingCourier.setSurnameCourier(courier.getSurnameCourier());
                    existingCourier.setNameCourier(courier.getNameCourier());
                    openNextWindow();

                }
                else{
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Помилка");
                    alert.setHeaderText(null);
                    alert.setContentText("Такий кур'єр відсутній!");
                    alert.showAndWait();
                    loginEnter.clear();
                    passwordEnter.clear();
                }break;
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Спочатку заповніть поля!");
            alert.showAndWait();
        }
    }

    @FXML
    void closeButtonAction() throws Exception{
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.hide();
        URL url = new File("src/main/java/sample/view/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.showAndWait();
        stage.close();
    }

    private void openNextWindow() throws Exception{
        Stage stage = (Stage) closeButton.getScene().getWindow();
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
