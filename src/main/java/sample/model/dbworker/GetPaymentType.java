package sample.model.dbworker;

import sample.model.PaymentType;

import java.sql.*;
import java.util.*;

public class GetPaymentType {
    private List<PaymentType> paymentTypes;

    public List<PaymentType> getPaymentTypeList() {
        return paymentTypes;
    }

    public GetPaymentType() {
        paymentTypes = new ArrayList<>();
    }

    public List<PaymentType> getPaymentTypes() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM PAYMENT_TYPE";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                PaymentType paymentType = new PaymentType();
                paymentType.setIdType(resultSet.getInt(1));
                paymentType.setPaymentTypeName(resultSet.getString(2));
                paymentTypes.add(paymentType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paymentTypes;
    }
}
