package sample.controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class ControllerOrderSuccess {

    @FXML
    private Button docButtonText;

    @FXML
    private Button creatorButtonText;

    @FXML
    private Button backToMainBttn;

    @FXML
    private Button exitBttn;

    @FXML
    private Button helpButtonText;

    @FXML
    private Button logInButton;
    @FXML
    private void loginButtonAction() throws Exception{
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
    private void backToMainAction() throws Exception{
        Stage stage = (Stage) backToMainBttn.getScene().getWindow();
        stage.close();
        URL url = new File("src/main/java/sample/view/sample.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        Stage newStage = new Stage();
        newStage.setScene(new Scene(root));
        newStage.initStyle(StageStyle.UNDECORATED);
        newStage.show();
    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) exitBttn.getScene().getWindow();
        stage.close();
    }

}