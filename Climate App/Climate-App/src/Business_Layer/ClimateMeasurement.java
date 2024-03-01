package Business_Layer;

public class ClimateMeasurement {
    private int month;
    private int year;
    ClimateMeasurement(int month,int year){
        this.month=month;
        this.year=year;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }
}
