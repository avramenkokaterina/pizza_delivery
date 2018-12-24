package sample.model.dbworker.requests;

import sample.model.Invoice;
import sample.model.dbworker.DBWorker;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InvoiceDelete {
    private List<Invoice> invoices;
    public InvoiceDelete(){
        invoices = new ArrayList<>();
    }

    public List<Invoice> getInvoicesDeleteList() {
        return invoices;
    }

    public List<Invoice> getInvoices(int id){
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "DELETE\n" +
                "FROM INVOICE\n" +
                "WHERE ID_INVOICE  =  '"+id+"'";
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
        return invoices;
    }
}
