package sample.model;

public class Payment {
    private int idPayment;
    private int idType;
    private int totalPrice;
    private String paymentTime;


    public Payment(int idPayment, int idType, int totalPrice, String paymentTime) {
        this.idPayment = idPayment;
        this.idType = idType;
        this.totalPrice = totalPrice;
        this.paymentTime = paymentTime;
    }

    public void setIdPayment(int idPayment) {
        this.idPayment = idPayment;
    }

    public int getIdPayment() {
        return idPayment;
    }

    public int getIdType() {
        return idType;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPaymentTime() {
        return paymentTime;
    }

    public void setPaymentTime(String paymentTime) {
        this.paymentTime = paymentTime;
    }
}
