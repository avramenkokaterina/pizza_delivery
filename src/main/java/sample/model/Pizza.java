package sample.model;

import javafx.scene.image.Image;

public class Pizza {
    private int idPizza;
    private String pizzaName;
    private int price;
    private Image image;

    public Pizza(){}

    public Pizza(int idPizza, String pizzaName, int price, Image image) {
        this.idPizza = idPizza;
        this.pizzaName = pizzaName;
        this.price = price;
        this.image = image;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }
}
