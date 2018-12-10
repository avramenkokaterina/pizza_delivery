package sample.model.dbworker;

import sample.model.Ingredient;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class GetIngredient {

    private List<Ingredient> ingredients;

    public GetIngredient(){
        ingredients = new ArrayList<>();
    }

    public List<Ingredient> getIngredientsList(){
        return ingredients;
    }

    public List<Ingredient> getCourier(){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM INGREDIENT";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Ingredient ingredient = new Ingredient();
                ingredient.setIdIngr(resultSet.getInt(1));
                ingredient.setNameIngr(resultSet.getString(2));
                ingredient.setPrice(resultSet.getInt(3));
                ingredients.add(ingredient);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ingredients;
    }
}
