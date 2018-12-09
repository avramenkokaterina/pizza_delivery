package sample.model;

public class Invoice {
    private int idInvoice;
    private int idPayment;
    private int idCustomer;
    private int idCourier;
    private String purchaseTime;
    private String arrivingTime;
    private String status;


    public Invoice(int idInvoice, int idPayment, int idCustomer, int idCourier, String purchaseTime, String arrivingTime, String status) {
        this.idInvoice = idInvoice;
        this.idPayment = idPayment;
        this.idCustomer = idCustomer;
        this.idCourier = idCourier;
        this.purchaseTime = purchaseTime;
        this.arrivingTime = arrivingTime;
        this.status = status;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public String getArrivingTime() {
        return arrivingTime;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getStatus() {
        return status;
    }

    public void setArrivingTime(String arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
