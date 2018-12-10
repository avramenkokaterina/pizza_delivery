package sample.model.dbworker;

import sample.model.Unit;

import java.sql.*;
import java.util.*;

public class GetUnit {
    private List<Unit> units;

    public List<Unit> getUnitsList() {
        return units;
    }

    public GetUnit(){
        units = new ArrayList<>();
    }

    public List<Unit> getUnits() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM UNIT";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Unit unit = new Unit();
                unit.setIdUnit(resultSet.getInt(1));
                unit.setUnitName(resultSet.getString(2));
                unit.setWeigth(resultSet.getInt(3));
                unit.setPrice(resultSet.getInt(4));
                units.add(unit);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return units;
    }
}
