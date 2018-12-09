package sample.model;

public class Customer {
    private int idCustomer;
    private String customerName;
    private String customerSurname;
    private String city;
    private String street;
    private int building;
    private String telephone;
    private String email;


    public Customer(int idCustomer, String customerName, String customerSurname, String city, String street, int building, String telephone, String email) {
        this.idCustomer = idCustomer;
        this.customerName = customerName;
        this.customerSurname = customerSurname;
        this.city = city;
        this.street = street;
        this.building = building;
        this.telephone = telephone;
        this.email = email;
    }

    public int getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(int idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerSurname() {
        return customerSurname;
    }

    public void setCustomerSurname(String customerSurname) {
        this.customerSurname = customerSurname;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getBuilding() {
        return building;
    }

    public void setBuilding(int building) {
        this.building = building;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
