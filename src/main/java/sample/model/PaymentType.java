package sample.model;

public class PaymentType {
    private int idType;
    private String paymentTypeName;


    public PaymentType(int idType, String paymentTypeName) {
        this.idType = idType;
        this.paymentTypeName = paymentTypeName;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public int getIdType() {
        return idType;
    }

    public String getPaymentTypeName() {
        return paymentTypeName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeName = paymentTypeName;
    }
}
