package sample.model;

public class Courier {
    private int idCourier;
    private String nameCourier;
    private String nameSurname;
    private String login;
    private String password;


    public Courier(int idCourier, String nameCourier, String nameSurname, String login, String password) {
        this.idCourier = idCourier;
        this.nameCourier = nameCourier;
        this.nameSurname = nameSurname;
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

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
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
}
