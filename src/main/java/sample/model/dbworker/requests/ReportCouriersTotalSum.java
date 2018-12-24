package sample.model.dbworker.requests;

public class ReportCouriersTotalSum {
    private String nameCourier;
    private int totalSum;


    public ReportCouriersTotalSum(){}

    public ReportCouriersTotalSum(String nameCourier, int totalSum) {
        this.nameCourier = nameCourier;
        this.totalSum = totalSum;
    }

    public String getNameCourier() {
        return nameCourier;
    }

    public void setNameCourier(String nameCourier) {
        this.nameCourier = nameCourier;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }
}
