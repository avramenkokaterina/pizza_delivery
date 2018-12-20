package sample.model.dbworker.requests;

public class BestPizzasRequestResult {
    private int idPizza;
    private String pizzaName;
    private int rang;


    public BestPizzasRequestResult(int idPizza, String pizzaName, int rang) {
        this.idPizza = idPizza;
        this.pizzaName = pizzaName;
        this.rang = rang;
    }

    public BestPizzasRequestResult(){}

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public int getRang() {
        return rang;
    }

    public void setRang(int rang) {
        this.rang = rang;
    }
}
