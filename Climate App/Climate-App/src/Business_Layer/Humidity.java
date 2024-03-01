package Business_Layer;
import java.util.Random;
public class Humidity extends ClimateMeasurement{
    private double humidity;

    public Humidity(int month,int year){
        super(month,year);
this.humidity=randomlyAssignmantHumidity();
    }
    public double randomlyAssignmantHumidity(){
        Random random = new Random();

                double minHumidity = 0.0;
        double maxHumidity = 100.0;
        return minHumidity + (maxHumidity - minHumidity) * random.nextDouble();
    }

    public double getHumidity() {
        return humidity;
    }
    public boolean equals(Humidity otherHumidity) {
    	if(otherHumidity.getHumidity() == this.getHumidity()) {
    		return true;
    	}else {return false;
    	
    	}
    }
    
    public String toString(){
        return "year: "+getYear()+"month: " + getMonth()+ "humidity: " +humidity;
       
    }
}
