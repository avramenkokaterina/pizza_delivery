package sample.model;

public class PizzaIngr {
    private int idPizza;
    private int idIngr;
    private int quantity;

    public PizzaIngr(){}

    public PizzaIngr(int idPizza, int idIngr, int quantity) {
        this.idPizza = idPizza;
        this.idIngr = idIngr;
        this.quantity = quantity;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setIdIngr(int idIngr) {
        this.idIngr = idIngr;
    }

    public int getIdIngr() {
        return idIngr;
    }
}
