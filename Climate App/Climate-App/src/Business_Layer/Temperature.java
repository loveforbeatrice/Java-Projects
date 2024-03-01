package Business_Layer;
import java.util.Random;
public class Temperature extends ClimateMeasurement {
    private double celciusTemperature;

    Temperature(int month,int year) {
        super(month,year);
        this.celciusTemperature=randomlyAssignment();
    }
    public double randomlyAssignment(){
Random random= new Random();
        double min = -40.0;
        double max = 50.0;

        return  min + (max - min) * random.nextDouble();
    }
    public double convertUnit(int typeId) {

        if (typeId==1) {
            return getTemperatureCelcius();

        } else if (2 == typeId) {
            return toFahrenheit();

        } else {return toKelvin();

        }


    }
    public double toFahrenheit(){
        return (1.8*celciusTemperature)+32;
    }
    public double toKelvin(){
        return celciusTemperature+273.15;
    }
    public double getTemperatureCelcius(){
        return celciusTemperature;
    }
    public String toString(){
        return "year: "+getYear()+"month: " + getMonth()+ "temperature(C): " +celciusTemperature;
       
    }
    public boolean equals(Temperature otherTmp) {
    	if(otherTmp.getTemperatureCelcius() == this.getTemperatureCelcius()) {
    		return true;
    	}else {return false;
    	
    	}
    }


}
