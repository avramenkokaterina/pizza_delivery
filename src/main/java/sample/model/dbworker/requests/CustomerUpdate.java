package sample.model.dbworker.requests;

import sample.model.Customer;
import sample.model.dbworker.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerUpdate {
    private List<Customer> customers;
    public CustomerUpdate(){
        customers = new ArrayList<>();
    }

    public List<Customer> getCustomersUpdateList() {
        return customers;
    }

    public List<Customer> getCustomers(int id, String phone){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "UPDATE CUSTOMER  \n" +
                "SET TELEPHONE = '" + phone+"'\n" +
                "WHERE ID_CUSTOMER =  '"+id+"'";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

//            while(resultSet.next()){
//                Customer customer = new Customer();
//                customer.setIdCustomer(resultSet.getInt(1));
//                customer.setCustomerName(resultSet.getString(2));
//                customer.setCustomerSurname(resultSet.getString(3));
//                customer.setCity(resultSet.getString(4));
//                customer.setStreet(resultSet.getString(5));
//                customer.setBuilding(resultSet.getInt(6));
//                customer.setTelephone(resultSet.getString(7));
//                customer.setEmail(resultSet.getString(8));
//                customers.add(customer);
//            }
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
