package sample.model.dbworker.requests;

public class ReportPizzasRequestResult {
    private String pizzaName;
    private String purchaseTime;
    private int price;
    private String pizzaSize;

    public ReportPizzasRequestResult(){}

    public ReportPizzasRequestResult(String pizzaName, String purchaseTime, int price, String pizzaSize) {
        this.pizzaName = pizzaName;
        this.purchaseTime = purchaseTime;
        this.price = price;
        this.pizzaSize = pizzaSize;
    }

    public String getPizzaName() {
        return pizzaName;
    }

    public void setPizzaName(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPurchaseTime() {
        return purchaseTime;
    }

    public void setPurchaseTime(String purchaseTime) {
        this.purchaseTime = purchaseTime;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getPizzaSize() {
        return pizzaSize;
    }

    public void setPizzaSize(String pizzaSize) {
        this.pizzaSize = pizzaSize;
    }
}
