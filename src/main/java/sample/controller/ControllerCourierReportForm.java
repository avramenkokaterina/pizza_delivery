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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.poi.ss.usermodel.IndexedColors;
import sample.model.dbworker.DBWorker;
import sample.model.dbworker.requests.ReportBestCouriers;
import sample.model.dbworker.requests.ReportCouriersTotalSum;
import sample.model.dbworker.requests.ReportPizzasRequestResult;

import java.awt.*;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ControllerCourierReportForm {

    @FXML
    private Button docButtonText;

    @FXML
    private Label name111;

    @FXML
    private Button creatorButtonText;

    @FXML
    private TableColumn<ReportBestCouriers, String> nameCourier1;

    @FXML
    private TableColumn<ReportCouriersTotalSum, String> nameCourier2;

    @FXML
    private TableColumn<ReportBestCouriers, Integer> idCourier;

    @FXML
    private Button logoutButton;

    @FXML
    private TableView<ReportBestCouriers> tableCourierBest;

    @FXML
    private ImageView wordBttn1;

    @FXML
    private ImageView wordBttn2;

    @FXML
    private ImageView wordBttn3;

    @FXML
    private TableColumn<ReportBestCouriers, Integer> better;

    @FXML
    private TableColumn<ReportCouriersTotalSum, Integer> totalSum;

    @FXML
    private Button closeBttn;

    @FXML
    private Label name11;

    @FXML
    private Label name;

    @FXML
    private TableColumn<ReportPizzasRequestResult, String> pizzaSize;

    @FXML
    private TableView<ReportPizzasRequestResult> tablePizzas;

    @FXML
    private TableColumn<ReportPizzasRequestResult, String> purchaseTime;

    @FXML
    private Button helpButtonText;

    @FXML
    private TableColumn<ReportPizzasRequestResult, String> pizzaName;

    @FXML
    private TableColumn<ReportPizzasRequestResult, Integer> pizzaPrice;

    @FXML
    private Label name1;

    @FXML
    private TableView<ReportCouriersTotalSum> tableSum;

    @FXML
    void logoutButtonAction() throws Exception {
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
    void creatorAction() {
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
    void docAction() {
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
    void helpAction() {
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
    void closeBttnAction() throws Exception {
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

    private ObservableList<ReportPizzasRequestResult> resultData1 = FXCollections.observableArrayList();
    private ObservableList<ReportBestCouriers> resultData2 = FXCollections.observableArrayList();
    private ObservableList<ReportCouriersTotalSum> resultData3 = FXCollections.observableArrayList();

    public ControllerCourierReportForm() {

    }

    public void initData() throws Exception {
        DBWorker worker = new DBWorker();
        Statement statement1 = null;
        Statement statement2 = null;
        Statement statement3 = null;


        String query1 = "SELECT p.pizza_name  name, i.purchase_time  time, (u.price + p.price)  price, u.unit_name || ' ' || u.weigth || 'г.' sizePizza,\n" +
                "    DENSE_RANK() OVER (ORDER BY i.purchase_time) RANK\n" +
                "    FROM (invoice i JOIN invoice_detail idet ON i.id_invoice = idet.id_invoice\n" +
                "        JOIN pizza p ON idet.id_pizza = p.id_pizza\n" +
                "        JOIN unit u ON idet.id_unit = u.id_unit)\n" +
                "    WHERE i.purchase_time >='01.01.2011'\n" +
                "    ORDER BY i.purchase_time";

        String query2 = "SELECT id, name ||' ' || name2 , count-1  FROM (\n" +
                "SELECT id, name, name2, RANK() OVER(ORDER BY count DESC) count FROM(\n" +
                "SELECT DISTINCT c.id_courier id ,c.courier_surname name ,c.courier_name name2, count(i.id_invoice) OVER(PARTITION BY c.courier_surname) count\n" +
                "FROM invoice i JOIN courier c ON i.id_courier = c.id_courier)) \n";

        String query3 = "SELECT c.courier_name || c.courier_surname , SUM(p.total_price)" +
                "FROM (courier c JOIN invoice i ON c.id_courier = i.id_courier\n" +
                "JOIN payment p ON p.id_payment=p.id_payment)\n" +
                "GROUP BY c.courier_name || c.courier_surname\n" +
                "ORDER BY  SUM(p.total_price)";

        try {
            statement1 = worker.getConnection().createStatement();
            statement2 = worker.getConnection().createStatement();
            statement3 = worker.getConnection().createStatement();

            ResultSet resultSet1 = statement1.executeQuery(query1);
            ResultSet resultSet2 = statement2.executeQuery(query2);
            ResultSet resultSet3 = statement3.executeQuery(query3);

            while (resultSet1.next()) {
                ReportPizzasRequestResult result1 = new ReportPizzasRequestResult();
                result1.setPizzaName(resultSet1.getString(1));
                result1.setPurchaseTime(resultSet1.getString(2));
                result1.setPrice(resultSet1.getInt(3));
                result1.setPizzaSize(resultSet1.getString(4));
                resultData1.add(result1);
            }

            while (resultSet2.next()) {
                ReportBestCouriers result2 = new ReportBestCouriers();
                result2.setIdCourier(resultSet2.getInt(1));
                result2.setNameCourier(resultSet2.getString(2));
                result2.setBetter(resultSet2.getInt(3));
                resultData2.add(result2);
            }

            while (resultSet3.next()) {
                ReportCouriersTotalSum result3 = new ReportCouriersTotalSum();
                result3.setNameCourier(resultSet3.getString(1));
                result3.setTotalSum(resultSet3.getInt(2));
                resultData3.add(result3);
            }

        } catch (
                SQLException e) {
            e.printStackTrace();
        }

        try {
            statement1.close();
            statement2.close();
            statement3.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void initialize()  throws Exception {
        initData();

        pizzaName.setCellValueFactory(new PropertyValueFactory<> ("pizzaName"));
        purchaseTime.setCellValueFactory(new PropertyValueFactory<>("purchaseTime"));
        pizzaPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        pizzaSize.setCellValueFactory(new PropertyValueFactory<>("pizzaSize"));
        tablePizzas.setItems(resultData1);

        idCourier.setCellValueFactory(new PropertyValueFactory<>("idCourier"));
        nameCourier1.setCellValueFactory(new PropertyValueFactory<>("nameCourier"));
        better.setCellValueFactory(new PropertyValueFactory<>("better"));
        tableCourierBest.setItems(resultData2);

        nameCourier2.setCellValueFactory(new PropertyValueFactory<>("nameCourier"));
        totalSum.setCellValueFactory(new PropertyValueFactory<>("totalSum"));
        tableSum.setItems(resultData3);
    }

    @FXML
    void wordBttn1Action() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("D:\\My Documents\\универ\\3 курс\\Курсач\\report\\PizzasReport.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Звіт по продажу піц");
            run.addCarriageReturn();
            run.setFontSize(16);
            run.setBold(true);
            run.setFontFamily("Century Gothic");
            XWPFRun paragraph2 = paragraph.createRun();
            paragraph2.setText("\nДаний звіт ілюструє які піци були замоплені після дати 01.01.2011, якого розміру та яка повна ціна.");
            //create table
            int i = 1;
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("Назва піци");
            tableRowOne.addNewTableCell().setText("Дата замовлення");
            tableRowOne.addNewTableCell().setText("Повна ціна");
            tableRowOne.addNewTableCell().setText("Розмір піци");
            for (ReportPizzasRequestResult reportPizzas: resultData1){
                table.createRow().getCell(0).setText(reportPizzas.getPizzaName());
                table.getRow(i).getCell(1).setText(reportPizzas.getPurchaseTime());
                table.getRow(i).getCell(2).setText(String.valueOf(reportPizzas.getPrice()));
                table.getRow(i).getCell(3).setText(reportPizzas.getPizzaSize());
                i++;
            }
            document.write(out);
            out.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Повідомлення");
            alert.setHeaderText(null);
            alert.setContentText("Звіт успішно створено!");
            alert.showAndWait();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void wordBttn2Action() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("D:\\My Documents\\универ\\3 курс\\Курсач\\report\\BestCouriersReport.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Звіт по кращих працівниках");
            run.addCarriageReturn();
            run.setFontSize(16);
            run.setBold(true);
            run.setFontFamily("Century Gothic");
            XWPFRun paragraph2 = paragraph.createRun();
            paragraph2.setText("\nДаний звіт ілюструє скільки є кур'єрів, що кращі за поточного в комірці, за критерієм \"кількість замовлень\"." +
                    "\nТобто скільки є кур'єрів, у яких кількість замовлень більша.");
            //create table
            int i = 1;
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("ID Кур'єра");
            tableRowOne.addNewTableCell().setText("Ім'я та прізвище");
            tableRowOne.addNewTableCell().setText("Кількість кращих кур'єрів");
            for (ReportBestCouriers reportBestCouriers: resultData2){
                table.createRow().getCell(0).setText(String.valueOf(reportBestCouriers.getIdCourier()));
                table.getRow(i).getCell(1).setText(reportBestCouriers.getNameCourier());
                table.getRow(i).getCell(2).setText(String.valueOf(reportBestCouriers.getBetter()));
                i++;
            }
            document.write(out);
            out.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Повідомлення");
            alert.setHeaderText(null);
            alert.setContentText("Звіт успішно створено!");
            alert.showAndWait();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    @FXML
    void wordBttn3Action() {
        try {
            XWPFDocument document = new XWPFDocument();
            FileOutputStream out = new FileOutputStream(new File("D:\\My Documents\\универ\\3 курс\\Курсач\\report\\CouriersTotalSumReport.docx"));
            XWPFParagraph paragraph = document.createParagraph();
            XWPFRun run = paragraph.createRun();
            run.setText("Звіт зального прибутку від кожного кур'єра");
            run.addCarriageReturn();
            run.setFontSize(16);
            run.setBold(true);
            run.setFontFamily("Century Gothic");
            XWPFRun paragraph2 = paragraph.createRun();
            paragraph2.setText("\nДаний звіт ілюструє загальну суму, яку заробив кожен кур'єр.");
            //create table
            int i = 1;
            XWPFTable table = document.createTable();
            XWPFTableRow tableRowOne = table.getRow(0);
            tableRowOne.getCell(0).setText("Ім'я та прізвище");
            tableRowOne.addNewTableCell().setText("Загальна вартість замовлень");
            for (ReportCouriersTotalSum reportCouriersTotalSum: resultData3){
                table.createRow().getCell(0).setText(reportCouriersTotalSum.getNameCourier());
                table.getRow(i).getCell(1).setText(String.valueOf(reportCouriersTotalSum.getTotalSum()));
                i++;
            }
            document.write(out);
            out.close();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Повідомлення");
            alert.setHeaderText(null);
            alert.setContentText("Звіт успішно створено!");
            alert.showAndWait();

        } catch (Exception e){
            e.printStackTrace();
        }
    }

}
