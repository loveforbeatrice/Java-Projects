package Business_Layer;
import java.util.Random;
public class WindSpeed extends ClimateMeasurement{
    private double windSpeedMetersPerSecond;
    WindSpeed(int month,int year){
        super(month,year);
        this.windSpeedMetersPerSecond=randomlyAssignmentWindSpeed();
    }
    public double randomlyAssignmentWindSpeed(){

        Random random = new Random();


        double minMetersPerSecond = 0.0;
        double maxMetersPerSecond = 113.2;

        return  minMetersPerSecond + (maxMetersPerSecond - minMetersPerSecond) * random.nextDouble();
    }
    public double toPerKmPerHour(){
        return windSpeedMetersPerSecond*3.6;
    }
    public double getWindSpeedMetersPerSecond(){
        return windSpeedMetersPerSecond;
    }
    public String toString(){
        return "year: "+getYear()+"month: " + getMonth()+ "wind speed(m/s):  " +windSpeedMetersPerSecond;
       
    }
    public boolean equals(WindSpeed otherWindSpeed) {
    	if(otherWindSpeed.getWindSpeedMetersPerSecond() == this.getWindSpeedMetersPerSecond()) {
    		return true;
    	}else {return false;
    	
    	}
    }
}
