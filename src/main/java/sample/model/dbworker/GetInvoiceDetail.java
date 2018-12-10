package sample.model.dbworker;

import sample.model.InvoiceDetail;

import java.sql.*;
import java.util.*;


public class GetInvoiceDetail {
    private List<InvoiceDetail> invoiceDetails;

    public List<InvoiceDetail> getInvoiceDetailsList() {
        return invoiceDetails;
    }

    public GetInvoiceDetail() {
        invoiceDetails = new ArrayList<>();
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        DBWorker worker = new DBWorker();
        Statement statement = null;
        String query = "SELECT * FROM INVOICE_DETAIL";
        try {
            statement = worker.getConnection().createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                InvoiceDetail invoiceDetail = new InvoiceDetail();
                invoiceDetail.setIdInvoice(resultSet.getInt(1));
                invoiceDetail.setIdPizza(resultSet.getInt(2));
                invoiceDetail.setQuantity(resultSet.getInt(3));
                invoiceDetail.setIdUnit(resultSet.getInt(4));
                invoiceDetails.add(invoiceDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return invoiceDetails;
    }
}
