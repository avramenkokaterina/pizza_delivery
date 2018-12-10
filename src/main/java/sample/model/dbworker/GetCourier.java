package sample.model.dbworker;

import sample.model.Courier;

import java.sql.*;
import java.util.*;

public class GetCourier {

    private List<Courier> couriers;

    public GetCourier(){
        couriers = new ArrayList<>();
    }

    public List<Courier> getCouriersList(){
        return couriers;
    }

    public List<Courier> getCourier(){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM COURIER";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Courier courier = new Courier();
                courier.setIdCourier(resultSet.getInt(1));
                courier.setNameCourier(resultSet.getString(2));
                courier.setSurnameCourier(resultSet.getString(3));
                courier.setLogin(resultSet.getString(4));
                courier.setPassword(resultSet.getString(5));
                couriers.add(courier);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return couriers;
    }
}
