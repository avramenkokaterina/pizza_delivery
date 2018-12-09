package sample.controller.dbworker;

import java.sql.*;
import java.util.Locale;

public class DBWorker {
    private final String HOST = "jdbc:oracle:thin:@localhost:1521:XE";
    private final String USERNAME = "KATERYNAAVRAMENKO";
    private final String PASSWORD = "KaterynaAvramenko";

    private Connection connection;

    public DBWorker(){
        Locale.setDefault(Locale.ENGLISH);
        try {
            Class.forName ("oracle.jdbc.driver.OracleDriver").newInstance();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException ex){
            ex.printStackTrace();
        } catch (InstantiationException ex){
            ex.printStackTrace();
        }

        connection = null;

        try{
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
        } catch (SQLException ex){
            ex.printStackTrace();
        }
    }

}
