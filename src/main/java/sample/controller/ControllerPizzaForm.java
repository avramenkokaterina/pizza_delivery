package sample.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.model.dbworker.DBWorker;
import sample.model.dbworker.requests.BestPizzasRequestResult;
import sample.model.dbworker.requests.PizzaFormRequestResult;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ControllerPizzaForm {

    @FXML
    private Button docButtonText;

    @FXML
    private Button exitBttn;

    @FXML
    private AnchorPane pane22;

    @FXML
    private Label price18;

    @FXML
    private Label price19;

    @FXML
    private AnchorPane pane21;

    @FXML
    private AnchorPane pane20;

    @FXML
    private Label price10;

    @FXML
    private Label price11;

    @FXML
    private Label price12;

    @FXML
    private Label price13;

    @FXML
    private Label price14;

    @FXML
    private Label price15;

    @FXML
    private Label price16;

    @FXML
    private Label price17;

    @FXML
    private Button orderButton;

    @FXML
    private AnchorPane pane12;

    @FXML
    private AnchorPane pane11;

    @FXML
    private AnchorPane pane14;

    @FXML
    private Label descr19;

    @FXML
    private AnchorPane pane13;

    @FXML
    private Label descr18;

    @FXML
    private AnchorPane pane16;

    @FXML
    private AnchorPane pane15;

    @FXML
    private AnchorPane pane18;

    @FXML
    private AnchorPane pane17;

    @FXML
    private Label descr13;

    @FXML
    private Label descr12;

    @FXML
    private Button pizzaTopBttn;

    @FXML
    private Label descr11;

    @FXML
    private Label descr10;

    @FXML
    private Label descr17;

    @FXML
    private ImageView image20;

    @FXML
    private Label descr16;

    @FXML
    private AnchorPane pane10;

    @FXML
    private Label descr15;

    @FXML
    private ImageView image22;

    @FXML
    private Label descr14;

    @FXML
    private ImageView image21;

    @FXML
    private Label name6;

    @FXML
    private Label name5;

    @FXML
    private Label descr9;

    @FXML
    private Label name4;

    @FXML
    private Label name3;

    @FXML
    private ImageView image17;

    @FXML
    private Label descr20;

    @FXML
    private Label name22;

    @FXML
    private Label name9;

    @FXML
    private ImageView image16;

    @FXML
    private Label name21;

    @FXML
    private Label name8;

    @FXML
    private ImageView image19;

    @FXML
    private Label name20;

    @FXML
    private Label name7;

    @FXML
    private ImageView image18;

    @FXML
    private Label descr2;

    @FXML
    private Label descr1;

    @FXML
    private AnchorPane pane19;

    @FXML
    private Label descr4;

    @FXML
    private Label descr3;

    @FXML
    private Label name2;

    @FXML
    private Label descr6;

    @FXML
    private Label name1;

    @FXML
    private Label descr5;

    @FXML
    private Label descr8;

    @FXML
    private Label descr7;

    @FXML
    private Button allPizzasBttn;

    @FXML
    private ImageView image13;

    @FXML
    private ImageView image12;

    @FXML
    private ImageView image15;

    @FXML
    private ImageView image14;

    @FXML
    private ImageView image11;

    @FXML
    private ImageView image10;

    @FXML
    private Button helpButtonText;

    @FXML
    private Label totalPricelbl;

    @FXML
    private Button logInButton;

    @FXML
    private ImageView image5;

    @FXML
    private ImageView image6;

    @FXML
    private ImageView image3;

    @FXML
    private ImageView image4;

    @FXML
    private ImageView image9;

    @FXML
    private Button addBttn13;

    @FXML
    private Button creatorButtonText;

    @FXML
    private Button addBttn12;

    @FXML
    private ImageView image7;

    @FXML
    private Button addBttn11;

    @FXML
    private ImageView image8;

    @FXML
    private Button addBttn10;

    @FXML
    private ImageView image1;

    @FXML
    private ImageView image2;

    @FXML
    private Label price21;

    @FXML
    private Label price22;

    @FXML
    private Button addBttn17;

    @FXML
    private Button addBttn16;

    @FXML
    private Button addBttn15;

    @FXML
    private Button addBttn14;

    @FXML
    private Button addButton1;

    @FXML
    private Button addBttn19;

    @FXML
    private Button addBttn18;

    @FXML
    private Label price20;

    @FXML
    private Button addBttn20;

    @FXML
    private Label price9;

    @FXML
    private Button addBttn22;

    @FXML
    private Button addBttn21;

    @FXML
    private AnchorPane pane8;

    @FXML
    private AnchorPane pane9;

    @FXML
    private AnchorPane pane1;

    @FXML
    private AnchorPane pane2;

    @FXML
    private AnchorPane pane3;

    @FXML
    private AnchorPane pane4;

    @FXML
    private AnchorPane pane5;

    @FXML
    private AnchorPane pane6;

    @FXML
    private AnchorPane pane7;

    @FXML
    private Label price7;

    @FXML
    private Label price8;

    @FXML
    private Label price5;

    @FXML
    private Label price6;

    @FXML
    private Label price3;

    @FXML
    private Label price4;

    @FXML
    private Label price1;

    @FXML
    private Label price2;

    @FXML
    private Label descr22;

    @FXML
    private Label descr21;

    @FXML
    private Label name19;

    @FXML
    private Label name18;

    @FXML
    private Label name17;

    @FXML
    private Label name16;

    @FXML
    private Label name15;

    @FXML
    private Label name14;

    @FXML
    private Label name13;

    @FXML
    private Label name12;

    @FXML
    private Label name11;

    @FXML
    private Label name10;

    @FXML
    private Button addBttn9;

    @FXML
    private Button addBttn7;

    @FXML
    private Button addBttn8;

    @FXML
    private Button addBttn5;

    @FXML
    private Button addBttn6;

    @FXML
    private Button addBttn3;

    @FXML
    private Button addBttn4;

    @FXML
    private Button addBttn2;

    @FXML
    private Button deleteButton;

    private PizzaFormRequestResult pizza;

    public PizzaFormRequestResult getPizza() {
        return pizza;
    }


    @FXML
    private void orderAction() throws Exception {
        if (getPizza() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Помилка");
            alert.setHeaderText(null);
            alert.setContentText("Спочатку оберіть одну піцу :)");
            alert.showAndWait();
        } else {
            Stage stage = (Stage) orderButton.getScene().getWindow();
            stage.hide();
            URL url = new File("src/main/java/sample/view/loginUserForm.fxml").toURI().toURL();
            Parent root = FXMLLoader.load(url);
            Stage newStage = new Stage();
            newStage.setScene(new Scene(root));
            newStage.initStyle(StageStyle.UNDECORATED);
            newStage.showAndWait();
            stage.close();
        }
    }

    @FXML
    private void deleteBttnAction() {
        totalPricelbl.setText("0.00 грн.");
    }

    @FXML
    private void loginButtonAction() throws Exception {
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

    private List<PizzaFormRequestResult> results;
    private List<BestPizzasRequestResult> resultsTop;
    private List<Label> names;
    private List<Label> descriptions;
    private List<Label> prices;
    private List<Button> orders;
    private List<ImageView> images;
    private List<AnchorPane> panes;

    public ControllerPizzaForm() {
        results = new ArrayList<>();
        resultsTop = new ArrayList<>();
        names = new ArrayList<>();
        descriptions = new ArrayList<>();
        prices = new ArrayList<>();
        orders = new ArrayList<>();
        images = new ArrayList<>();
        panes = new ArrayList<>();
    }

    public List<PizzaFormRequestResult> getResultsList() {
        return results;
    }

    public List<BestPizzasRequestResult> getResultsTopList() {
        return resultsTop;
    }

    public List<Label> getNames() {
        return names;
    }

    public List<Label> getDescriptions() {
        return descriptions;
    }

    public List<Label> getPrices() {
        return prices;
    }

    public List<Button> getOrders() {
        return orders;
    }

    public List<ImageView> getImages() {
        return images;
    }

    public List<AnchorPane> getPanes() {
        return panes;
    }

    private void makeLists() {
        names.add(name1);
        names.add(name2);
        names.add(name3);
        names.add(name4);
        names.add(name5);
        names.add(name6);
        names.add(name7);
        names.add(name8);
        names.add(name9);
        names.add(name10);
        names.add(name11);
        names.add(name12);
        names.add(name13);
        names.add(name14);
        names.add(name15);
        names.add(name16);
        names.add(name17);
        names.add(name18);
        names.add(name19);
        names.add(name20);
        names.add(name21);
        names.add(name22);
        descriptions.add(descr1);
        descriptions.add(descr2);
        descriptions.add(descr3);
        descriptions.add(descr4);
        descriptions.add(descr5);
        descriptions.add(descr6);
        descriptions.add(descr7);
        descriptions.add(descr8);
        descriptions.add(descr9);
        descriptions.add(descr10);
        descriptions.add(descr11);
        descriptions.add(descr12);
        descriptions.add(descr13);
        descriptions.add(descr14);
        descriptions.add(descr15);
        descriptions.add(descr16);
        descriptions.add(descr17);
        descriptions.add(descr18);
        descriptions.add(descr19);
        descriptions.add(descr20);
        descriptions.add(descr21);
        descriptions.add(descr22);
        prices.add(price1);
        prices.add(price2);
        prices.add(price3);
        prices.add(price4);
        prices.add(price5);
        prices.add(price6);
        prices.add(price7);
        prices.add(price8);
        prices.add(price9);
        prices.add(price10);
        prices.add(price11);
        prices.add(price12);
        prices.add(price13);
        prices.add(price14);
        prices.add(price15);
        prices.add(price16);
        prices.add(price17);
        prices.add(price18);
        prices.add(price19);
        prices.add(price20);
        prices.add(price21);
        prices.add(price22);
        orders.add(addButton1);
        orders.add(addBttn2);
        orders.add(addBttn3);
        orders.add(addBttn4);
        orders.add(addBttn5);
        orders.add(addBttn6);
        orders.add(addBttn7);
        orders.add(addBttn8);
        orders.add(addBttn9);
        orders.add(addBttn10);
        orders.add(addBttn11);
        orders.add(addBttn12);
        orders.add(addBttn13);
        orders.add(addBttn14);
        orders.add(addBttn15);
        orders.add(addBttn16);
        orders.add(addBttn17);
        orders.add(addBttn18);
        orders.add(addBttn19);
        orders.add(addBttn20);
        orders.add(addBttn21);
        orders.add(addBttn22);
        images.add(image1);
        images.add(image2);
        images.add(image3);
        images.add(image4);
        images.add(image5);
        images.add(image6);
        images.add(image7);
        images.add(image8);
        images.add(image9);
        images.add(image10);
        images.add(image11);
        images.add(image12);
        images.add(image13);
        images.add(image14);
        images.add(image15);
        images.add(image16);
        images.add(image17);
        images.add(image18);
        images.add(image19);
        images.add(image20);
        images.add(image21);
        images.add(image22);
        panes.add(pane1);
        panes.add(pane2);
        panes.add(pane3);
        panes.add(pane4);
        panes.add(pane5);
        panes.add(pane6);
        panes.add(pane7);
        panes.add(pane8);
        panes.add(pane9);
        panes.add(pane10);
        panes.add(pane11);
        panes.add(pane12);
        panes.add(pane13);
        panes.add(pane14);
        panes.add(pane15);
        panes.add(pane16);
        panes.add(pane17);
        panes.add(pane18);
        panes.add(pane19);
        panes.add(pane20);
        panes.add(pane21);
        panes.add(pane22);
    }

    @FXML
    private void allPizzasBttnAction() {
        initData();
        makeLists();
        int i = 0;
        for (Pane pane : panes) {
            pane.setVisible(true);
        }
        for (PizzaFormRequestResult pizzaForm : results) {
            images.get(i).setImage(pizzaForm.getImage());
            descriptions.get(i).setText(pizzaForm.getIngr());
            names.get(i).setText(pizzaForm.getPizzaName());
            prices.get(i).setText("Від " + pizzaForm.getPrice() + ".00 грн.");
            i++;
        }
    }

    @FXML
    private void pizzaTopBttnAction() {
        initData();
        makeLists();
        for (Pane pane : panes) {
            pane.setVisible(false);
        }
        int i = 0;
        int k = 0;
        int q = 0;
        String name;
        for (BestPizzasRequestResult pizzaBest : resultsTop) {
            name = resultsTop.get(q).getPizzaName();
            for (PizzaFormRequestResult pizzaForm : results) {
                String namePizza = results.get(i).getPizzaName();
                if (name.equals(namePizza)) {
                    panes.get(k).setVisible(true);
                    images.get(k).setImage(results.get(i).getImage());
                    descriptions.get(k).setText(results.get(i).getIngr());
                    names.get(k).setText(results.get(i).getPizzaName());
                    prices.get(k).setText("Від " + results.get(i).getPrice() + ".00 грн.");
                    k++;
                    q++;
                    break;
                }
                i++;
            }
            i = 0;
        }
    }

    @FXML
    public void initialize() {
        totalPricelbl.setText("0.00 грн.");
        initData();
        makeLists();
        int i = 0;
        for (PizzaFormRequestResult pizzaForm : results) {
            images.get(i).setImage(pizzaForm.getImage());
            descriptions.get(i).setText(pizzaForm.getIngr());
            names.get(i).setText(pizzaForm.getPizzaName());
            prices.get(i).setText("Від " + pizzaForm.getPrice() + ".00 грн.");
            i++;
        }
    }

    private void initData() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        Statement statementTop = null;
        results.clear();
        resultsTop.clear();

        String query = "SELECT p.pizza_name, pi.ings, p.price, p.image\n" +
                "    FROM pizza p JOIN pi ON pi.id_pizza = p.id_pizza\n" +
                "    ORDER BY p.price, p.pizza_name";

        String queryTopPizzas = "SELECT pizza.ID_PIZZA, pizza.pizza_name, COUNT (invoice_detail.id_invoice)\n" +
                "    FROM pizza JOIN invoice_detail ON pizza.id_pizza = invoice_detail.id_pizza\n" +
                "    GROUP BY pizza.ID_PIZZA, pizza.pizza_name\n" +
                "    HAVING COUNT (invoice_detail.id_invoice)>1" +
                "    ORDER BY pizza.ID_PIZZA";

        try {
            statement = worker.getConnection().createStatement();
            statementTop = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            ResultSet resultSetTop = statementTop.executeQuery(queryTopPizzas);
            while (resultSet.next()) {
                PizzaFormRequestResult result = new PizzaFormRequestResult();
                result.setPizzaName(resultSet.getString(1));
                result.setIngr(resultSet.getString(2));
                result.setPrice(resultSet.getInt(3));
                InputStream img = resultSet.getBlob(4).getBinaryStream();
                Image image = new Image(img);
                result.setImage(image);
                results.add(result);
            }

            while (resultSetTop.next()) {
                BestPizzasRequestResult bestPizza = new BestPizzasRequestResult();
                bestPizza.setIdPizza(resultSetTop.getInt(1));
                bestPizza.setPizzaName(resultSetTop.getString(2));
                bestPizza.setRang(resultSetTop.getInt(3));
                resultsTop.add(bestPizza);
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

    private void addBttnAction(Label namelbl, Label descrlbl, Label pricelbl, ImageView imageEl) {
        pizza = new PizzaFormRequestResult();
        pizza.setPizzaName(namelbl.getText());
        pizza.setIngr(descrlbl.getText());
        String price = pricelbl.getText();
        int startIndex = 4;
        int endIndex = price.indexOf(".");
        int newPrice = Integer.parseInt(price.substring(startIndex, endIndex));
        pizza.setPrice(newPrice);
        pizza.setImage(imageEl.getImage());
        totalPricelbl.setText(getPizza().getPrice() + ".00 грн.");
    }

    @FXML
    void addButton1Action() {
        addBttnAction(name1, descr1, price1, image1);
    }

    @FXML
    void addBttn2Action() {
        addBttnAction(name2, descr2, price2, image2);
    }

    @FXML
    void addBttn3Action() {
        addBttnAction(name3, descr3, price3, image3);
    }

    @FXML
    void addBttn6Action() {
        addBttnAction(name6, descr6, price6, image6);
    }

    @FXML
    void addBttn5Action() {
        addBttnAction(name5, descr5, price5, image5);
    }

    @FXML
    void addBttn4Action() {
        addBttnAction(name4, descr4, price4, image4);
    }

    @FXML
    void addBttn7Action() {
        addBttnAction(name7, descr7, price7, image7);
    }

    @FXML
    void addBttn9Action() {
        addBttnAction(name9, descr9, price9, image9);
    }

    @FXML
    void addBttn8Action() {
        addBttnAction(name8, descr8, price8, image8);
    }

    @FXML
    void addBttn10Action() {
        addBttnAction(name10, descr10, price10, image10);
    }

    @FXML
    void addBttn12Action() {
        addBttnAction(name12, descr12, price12, image12);
    }

    @FXML
    void addBttn11Action() {
        addBttnAction(name11, descr11, price11, image11);
    }

    @FXML
    void addBttn14Action() {
        addBttnAction(name14, descr14, price14, image14);
    }

    @FXML
    void addBttn15Action() {
        addBttnAction(name15, descr15, price15, image15);
    }

    @FXML
    void addBttn13Action() {
        addBttnAction(name13, descr13, price13, image13);
    }

    @FXML
    void addBttn18Action() {
        addBttnAction(name18, descr18, price18, image18);
    }

    @FXML
    void addBttn16Action() {
        addBttnAction(name16, descr16, price16, image16);
    }

    @FXML
    void addBttn17Action() {
        addBttnAction(name17, descr17, price17, image17);
    }

    @FXML
    void addBttn21Action() {
        addBttnAction(name21, descr21, price21, image21);
    }

    @FXML
    void addBttn19Action() {
        addBttnAction(name19, descr19, price19, image19);
    }

    @FXML
    void addBttn20Action() {
        addBttnAction(name20, descr20, price20, image20);
    }

    @FXML
    void addBttn22Action() {
        addBttnAction(name22, descr22, price22, image22);
    }

}

