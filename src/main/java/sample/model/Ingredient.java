package sample.model;

public class Ingredient {
    private int idIngr;
    private String nameIngr;
    private int price;


    public Ingredient(int idIngr, String nameIngr, int price) {
        this.idIngr = idIngr;
        this.nameIngr = nameIngr;
        this.price = price;
    }

    public int getIdIngr() {
        return idIngr;
    }

    public String getNameIngr() {
        return nameIngr;
    }

    public int getPrice() {
        return price;
    }

    public void setIdIngr(int idIngr) {
        this.idIngr = idIngr;
    }

    public void setNameIngr(String nameIngr) {
        this.nameIngr = nameIngr;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
