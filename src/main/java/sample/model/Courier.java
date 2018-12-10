package sample.model;

public class Courier {
    private int idCourier;
    private String nameCourier;
    private String surnameCourier;
    private String login;
    private String password;

    public Courier(){

    }

    public Courier(int idCourier, String nameCourier, String surnameCourier, String login, String password) {
        this.idCourier = idCourier;
        this.nameCourier = nameCourier;
        this.surnameCourier = surnameCourier;
        this.login = login;
        this.password = password;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public String getNameCourier() {
        return nameCourier;
    }

    public void setNameCourier(String nameCourier) {
        this.nameCourier = nameCourier;
    }

    public String getSurnameCourier() {
        return surnameCourier;
    }

    public void setSurnameCourier(String nameSurname) {
        this.surnameCourier = nameSurname;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString(){
        return idCourier + nameCourier + surnameCourier + login + password;
    }
}
