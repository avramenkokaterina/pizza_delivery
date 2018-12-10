package sample.model;

public class Unit {
    private int idUnit;
    private String unitName;
    private int weigth;
    private int price;

    public Unit(){}

    public Unit(int idUnit, String unitName, int weigth, int price) {
        this.idUnit = idUnit;
        this.unitName = unitName;
        this.weigth = weigth;
        this.price = price;
    }

    public void setIdUnit(int idUnit) {
        this.idUnit = idUnit;
    }

    public int getIdUnit() {
        return idUnit;
    }

    public int getWeigth() {
        return weigth;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public void setWeigth(int weigth) {
        this.weigth = weigth;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
