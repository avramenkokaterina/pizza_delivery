package sample.model.dbworker;

import sample.model.Pizza;

import java.sql.*;
import java.util.*;

public class GetPizza {
    private List<Pizza> pizzas;

    public List<Pizza> getPizzasList() {
        return pizzas;
    }

    public GetPizza(){
        pizzas = new ArrayList<>();
    }

    public List<Pizza> getPizzas() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM PIZZA";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Pizza pizza = new Pizza();
                pizza.setIdPizza(resultSet.getInt(1));
                pizza.setPizzaName(resultSet.getString(2));
                pizza.setPrice(resultSet.getInt(3));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }
}
