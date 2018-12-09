package sample.model;

public class InvoiceDetail {
    private int idInvoice;
    private int idPizza;
    private int quantity;
    private int idUnit;


    public InvoiceDetail(int idInvoice, int idPizza, int quantity, int idUnit) {
        this.idInvoice = idInvoice;
        this.idPizza = idPizza;
        this.quantity = quantity;
        this.idUnit = idUnit;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getIdPizza() {
        return idPizza;
    }

    public int getIdUnit() {
        return idUnit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setIdPizza(int idPizza) {
        this.idPizza = idPizza;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }
}
