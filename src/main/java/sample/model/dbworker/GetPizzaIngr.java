package sample.model.dbworker;

import sample.model.PizzaIngr;

import java.sql.*;
import java.util.*;

public class GetPizzaIngr {
    private List<PizzaIngr> pizzaIngrs;

    public List<PizzaIngr> getPizzaIngrsList() {
        return pizzaIngrs;
    }

    public GetPizzaIngr(){
        pizzaIngrs = new ArrayList<>();
    }

    public List<PizzaIngr> getPizzaIngrs() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM PIZZA_INGREDIENT";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                PizzaIngr pizzaIngr = new PizzaIngr();
                pizzaIngr.setIdPizza(resultSet.getInt(1));
                pizzaIngr.setIdIngr(resultSet.getInt(2));
                pizzaIngr.setQuantity(resultSet.getInt(3));
                pizzaIngrs.add(pizzaIngr);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzaIngrs;
    }
}
