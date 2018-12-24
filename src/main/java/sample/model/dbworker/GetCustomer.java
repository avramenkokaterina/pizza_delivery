package sample.model.dbworker;

import sample.model.Customer;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;


public class GetCustomer {
    private List<Customer> customers;

    public GetCustomer(){
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomersList(){
        return customers;
    }

    public List<Customer> getCustomers(){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM CUSTOMER";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Customer customer = new Customer();
                customer.setIdCustomer(resultSet.getInt(1));
                customer.setCustomerName(resultSet.getString(2));
                customer.setCustomerSurname(resultSet.getString(3));
                customer.setCity(resultSet.getString(4));
                customer.setStreet(resultSet.getString(5));
                customer.setBuilding(resultSet.getInt(6));
                customer.setTelephone(resultSet.getString(7));
                customer.setEmail(resultSet.getString(8));
                customers.add(customer);
            }

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
