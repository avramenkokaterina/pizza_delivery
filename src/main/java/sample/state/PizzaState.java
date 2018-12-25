package sample.state;

import sample.model.dbworker.requests.PizzaFormRequestResult;

public class PizzaState {

    private static PizzaState ourInstance = new PizzaState();

    public static PizzaState getInstance() {
        return ourInstance;
    }

    private PizzaState() {
    }

    private PizzaFormRequestResult pizza;

    public PizzaFormRequestResult getPizza() {
        return pizza;
    }

    public void setPizza(PizzaFormRequestResult pizza) {
        this.pizza = pizza;
    }
}
