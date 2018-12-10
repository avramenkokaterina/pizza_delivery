package sample.model.dbworker;

import sample.model.Invoice;

import java.sql.*;
import java.util.*;

public class GetInvoice {
    private List<Invoice> invoices;
    public GetInvoice(){
        invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoicesList() {
        return invoices;
    }

    public List<Invoice> getInvoices(){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM INVOICE";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while(resultSet.next()){
                Invoice invoice = new Invoice();
                invoice.setIdInvoice(resultSet.getInt(1));
                invoice.setIdPayment(resultSet.getInt(2));
                invoice.setIdCustomer(resultSet.getInt(3));
                invoice.setIdCourier(resultSet.getInt(4));
                invoice.setPurchaseTime(resultSet.getString(5));
                invoice.setArrivingTime(resultSet.getString(6));
                invoice.setStatus(resultSet.getString(7));
                invoices.add(invoice);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoices;
    }

}
