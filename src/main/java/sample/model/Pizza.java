package sample.model;

public class Pizza {
    private int idPizza;
    private String pizzaName;
    private int price;

    public Pizza(int idPizza, String pizzaName, int price) {
        this.idPizza = idPizza;
        this.pizzaName = pizzaName;
        this.price = price;
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
