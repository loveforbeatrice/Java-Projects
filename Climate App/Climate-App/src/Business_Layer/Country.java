package Business_Layer;

import java.util.ArrayList;

public class Country {
    private String name;
   private ArrayList<Temperature> temperatureArrayList;

     public Country(String name){
        this.name = name;
    }



    public String getName(){
        return name;
    }
    public String toString(){
        return "country name: "+name;
       
    }
    
   
public boolean nameCompareTo(String otherName){
         if(name.equals(otherName) ){
             return true;
         }
         else {
             return false;}

}
    public void setTemperatureArrayList(ArrayList<Temperature> temperatureArrayList) {
        this.temperatureArrayList = temperatureArrayList;
    }
    public boolean equals(Country otherCountry) {
    	if(otherCountry.getName() == this.name) {
    		return true;
    	}else {return false;
    	
    	}
    }

    public ArrayList<Temperature> getTemperatureArrayList() {
        return temperatureArrayList;
    }
}
