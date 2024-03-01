package Business_Layer;

import java.util.ArrayList;
import java.util.PropertyResourceBundle;

public class City {
    private String name;
    private ArrayList<Temperature> temperatureArrayList;
    private ArrayList<Humidity> humidityArrayList;
    private   ArrayList<WindSpeed> windSpeedArrayList;
    private ArrayList<RadiationAbsorbtion> radiationAbsorbtionArrayList;
    private ArrayList<Double>feltArrayList;




    public City(String name){
        this.name = name;

    }


    public String getName(){

        return name;
    }
    public String toString(){
        return "city name: "+name;
       
    }

    public boolean nameCompareTo(String otherName) {
        if (name.equals(otherName)) {
            return true;
        } else {
            return false;
        }
    }



    public void setHumidityArrayList(ArrayList<Humidity> humidityArrayList) {
        this.humidityArrayList = humidityArrayList;
    }

    public void setRadiationAbsorbtionArrayList(ArrayList<RadiationAbsorbtion> radiationAbsorbtionArrayList) {
            this.radiationAbsorbtionArrayList = radiationAbsorbtionArrayList;
    }

    public void setTemperatureArrayList(ArrayList<Temperature> temperatureArrayList) {
        this.temperatureArrayList = temperatureArrayList;
    }

    public void setWindSpeedArrayList(ArrayList<WindSpeed> windSpeedArrayList) {
        this.windSpeedArrayList = windSpeedArrayList;
    }

    public ArrayList<Temperature> getTemperatureArrayList() {
        return temperatureArrayList;

    }
    public ArrayList<Humidity> getHumidityArrayList() {
        return humidityArrayList;
    }

    public ArrayList<RadiationAbsorbtion> getRadiationAbsorbtionArrayList() {
        return radiationAbsorbtionArrayList;
    }

    public ArrayList<WindSpeed> getWindSpeedArrayList() {
        return windSpeedArrayList;
    }

    public boolean equals(City otherCity) {
    	if(otherCity.getName() == this.name) {
    		return true;
    	}else {return false;
    	
    	}
    }
    //This method is created to return the felt temperature value using the index parameter.
    public double calculteFelt(int index) {
        double felt = temperatureArrayList.get(index).getTemperatureCelcius() + 0.3 * (humidityArrayList.get(index).getHumidity() / 100) - (radiationAbsorbtionArrayList.get(index).getUnitAbsorbtionValue() / (windSpeedArrayList.get(index).getWindSpeedMetersPerSecond() + 10));
return felt;
    }
}



