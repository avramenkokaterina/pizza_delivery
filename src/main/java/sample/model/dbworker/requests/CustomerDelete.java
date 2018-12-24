package sample.model.dbworker.requests;

import sample.model.Customer;
import sample.model.dbworker.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerDelete {
    private List<Customer> customers;
    public CustomerDelete(){
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomerDeleteList() {
        return customers;
    }

    public List<Customer> getCustomers(int id){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "DELETE\n" +
                "FROM CUSTOMER\n" +
                "WHERE ID_CUSTOMER  =  '"+id+"'";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customers;
    }
}
