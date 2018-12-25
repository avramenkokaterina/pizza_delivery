package sample.state;

import sample.model.Courier;

public class CourierState {
    private static CourierState ourInstance = new CourierState();

    public static CourierState getInstance() {
        return ourInstance;
    }

    private CourierState() {
    }

    private Courier courier;

    public Courier getCourier() {
        return courier;
    }

    public void setCourier(Courier courier) {
        this.courier = courier;
    }
}
