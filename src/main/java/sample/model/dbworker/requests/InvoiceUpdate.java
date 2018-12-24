package sample.model.dbworker.requests;

import sample.model.Invoice;
import sample.model.dbworker.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceUpdate {
    private List<Invoice> invoices;
    public InvoiceUpdate(){
        invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoicesUpdateList() {
        return invoices;
    }

    public List<Invoice> getInvoices(int id, String newDate){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "UPDATE INVOICE  \n" +
                "SET ARRIVING_TIME = '" + newDate+"'\n" +
                "WHERE ID_INVOICE =  '"+id+"'";
        try{
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

//            while(resultSet.next()){
//                Invoice invoice = new Invoice();
//                invoice.setIdInvoice(resultSet.getInt(1));
//                invoice.setIdPayment(resultSet.getInt(2));
//                invoice.setIdCustomer(resultSet.getInt(3));
//                invoice.setIdCourier(resultSet.getInt(4));
//                invoice.setPurchaseTime(resultSet.getString(5));
//                invoice.setArrivingTime(resultSet.getString(6));
//                invoice.setStatus(resultSet.getString(7));
//                invoices.add(invoice);
//            }
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
