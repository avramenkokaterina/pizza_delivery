package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Controller {

    @FXML
    private Button docButtonText;

    @FXML
    private Button creatorButtonText;

    @FXML
    private ImageView creatorPic;

    @FXML
    private Button exitBttn;

    @FXML
    private Button helpButtonText;

    @FXML
    private Button logInButton;

    @FXML
    private ImageView docPic;

    @FXML
    private Button orderButton;

    @FXML
    private ImageView helpPic;


    @FXML
    public void initialize() {

    }

    @FXML
    private void closeButtonAction() {
        Stage stage = (Stage) exitBttn.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void orderButtonAction() throws Exception{
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

    @FXML
    private void orderMouseOn(){
        orderButton.setTextFill(Color.web("#ffffff"));
        orderButton.setFont(Font.font("Century Gothic", FontWeight.BOLD, 24));
        orderButton.setStyle("-fx-background-color: #ce343e; ");
    }

    @FXML
    private void orderMouseOut(){
        orderButton.setTextFill(Color.web("#ce343e"));
        orderButton.setFont(Font.font("Century Gothic", FontWeight.NORMAL, 24));
        orderButton.setStyle("-fx-background-color: #ffffff; " +
                "-fx-border-radius: 7; " +
                "-fx-border-width: 2; " +
                "-fx-background-radius: 7; " +
                "-fx-border-color: #ce343e; ");
    }

    @FXML
    private void loginButtonAction() throws Exception{
        Stage stage = (Stage) exitBttn.getScene().getWindow();
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
    private void loginMouseOn(){
        logInButton.setTextFill(Color.web("#ce343e"));
    }

    @FXML
    private void loginMouseOut(){
        logInButton.setTextFill(Color.web("#ffffff"));
    }

    @FXML
    private void creatorMouseOn(){
        creatorButtonText.setTextFill(Color.web("#ce343e"));
        File file = new File("sources/dollred.png");
        Image image = new Image(file.toURI().toString());
        creatorPic.setImage(image);
    }

    @FXML
    private void creatorPicMouseOn(){
        creatorMouseOn();
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
    private void documentationMouseOn(){
        docButtonText.setTextFill(Color.web("#ce343e"));
        File file = new File("sources/documentred.png");
        Image image = new Image(file.toURI().toString());
        docPic.setImage(image);
    }

    @FXML
    private void docPicMouseOn(){
        documentationMouseOn();
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
    private void helpMouseOn(){
        helpButtonText.setTextFill(Color.web("#ce343e"));
        File file = new File("sources/conversationred.png");
        Image image = new Image(file.toURI().toString());
        helpPic.setImage(image);
    }

    @FXML
    private void helpPicMouseOn(){
        helpMouseOn();
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
    private void creatorMouseOut(){
        creatorButtonText.setTextFill(Color.web("#ffffff"));
        File file = new File("sources/dollw.png");
        Image image = new Image(file.toURI().toString());
        creatorPic.setImage(image);
    }

    @FXML
    private void creatorPicMouseOut(){
        creatorMouseOut();
    }

    @FXML
    private void documentationMouseOut(){
        docButtonText.setTextFill(Color.web("#ffffff"));
        File file = new File("sources/documentw.png");
        Image image = new Image(file.toURI().toString());
        docPic.setImage(image);
    }

    @FXML
    private void docPicMouseOut(){
        documentationMouseOut();
    }

    @FXML
    private void helpMouseOut(){
        helpButtonText.setTextFill(Color.web("#ffffff"));
        File file = new File("sources/conversationw.png");
        Image image = new Image(file.toURI().toString());
        helpPic.setImage(image);
    }

    @FXML
    private void helpPicMouseOut(){
        helpMouseOut();
    }
}
