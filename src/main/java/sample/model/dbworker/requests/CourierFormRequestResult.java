package sample.model.dbworker.requests;

public class CourierFormRequestResult {
    private int idInvoice;
    private int idPayment;
    private String paymentTypeName;
    private String pizzaName;
    private int quantity;
    private int idCustomer;
    private String courier;
    private String purchaseTime;
    private String arrivingTime;
    private String status;

    public CourierFormRequestResult(){}

    public CourierFormRequestResult(int idInvoice, int idPayment, String paymentTypeName, String pizzaName, int quantity, int idCustomer, String courier, String purchaseTime, String arrivingTime, String status) {
        this.idInvoice = idInvoice;
        this.idPayment = idPayment;
        this.paymentTypeName = paymentTypeName;
        this.pizzaName = pizzaName;
        this.quantity = quantity;
        this.idCustomer = idCustomer;
        this.courier = courier;
        this.purchaseTime = purchaseTime;
        this.arrivingTime = arrivingTime;
        this.status = status;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(int idInvoice) {
        this.idInvoice = idInvoice;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public void setArrivingTime(String arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public String getStatus() {
        return status;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public String getArrivingTime() {
        return arrivingTime;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCourier() {
        return courier;
    }

    public void setCourier(String courier) {
        this.courier = courier;
    }

}
