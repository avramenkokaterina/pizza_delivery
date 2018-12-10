package sample.model.dbworker;

import sample.model.Payment;

import java.sql.*;
import java.util.*;

public class GetPayment {
    private List<Payment> payments;

    public GetPayment(){
        payments = new ArrayList<>();
    }

    public List<Payment> getPaymentsList() {
        return payments;
    }

    public List<Payment> getPayments() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM PAYMENT";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                Payment payment = new Payment();
                payment.setIdPayment(resultSet.getInt(1));
                payment.setIdType(resultSet.getInt(2));
                payment.setTotalPrice(resultSet.getInt(3));
                payment.setPaymentTime(resultSet.getString(4));
                payments.add(payment);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payments;
    }
}
