package sample.model.dbworker.requests;

import javafx.scene.image.Image;
//import java.awt.Image;

public class PizzaFormRequestResult {
    private String pizzaName;
    private String ingr;
    private int price;
    private Image image;


    public PizzaFormRequestResult() {
    }

    public PizzaFormRequestResult(String pizzaName, String ingr, int price, Image image) {
        this.pizzaName = pizzaName;
        this.ingr = ingr;
        this.price = price;
        this.image = image;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getIngr() {
        return ingr;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setIngr(String ingr) {
        this.ingr = ingr;
    }

    public Image getImage() {
        return image;
    }
}
