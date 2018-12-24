package sample.model.dbworker.requests;

public class ReportBestCouriers {
    private int idCourier;
    private String nameCourier;
    private int better;

    public ReportBestCouriers(){}
    public ReportBestCouriers(int idCourier, String nameCourier, int better) {
        this.idCourier = idCourier;
        this.nameCourier = nameCourier;
        this.better = better;
    }

    public int getIdCourier() {
        return idCourier;
    }

    public void setIdCourier(int idCourier) {
        this.idCourier = idCourier;
    }

    public void setNameCourier(String nameCourier) {
        this.nameCourier = nameCourier;
    }

    public String getNameCourier() {
        return nameCourier;
    }

    public int getBetter() {
        return better;
    }

    public void setBetter(int better) {
        this.better = better;
    }
}
