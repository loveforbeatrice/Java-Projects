package Business_Layer;

import Data_Access_Layer.FileIO;

import java.util.ArrayList;

public class ClimateRecord {
    private ArrayList<City> cities;
    private ArrayList<Country> countries;

    public ClimateRecord() {
        this.cities = new ArrayList<>();
        this.countries=new ArrayList<>();
        createCityObject();;
        createCountryObject();
        assignmentTempratureToCities();
        assignmentHumidityToCities();
        assignmentWindSpeedToCities();
        assignmenRadiationAbsorbtionToCities();
        assignmentTempratureToCountries();

    }

//we used this classes to create cities and countries and to fill them with arraylists
private void createCityObject(){
       ArrayList <String[]> locationList= FileIO.readLocationData("countries_and_cities.csv");
    for (String[] locations:
         locationList) {
        for (int i=1;i<locations.length;i++){
            City city= new City(locations[i].replaceAll("\\s", "").toLowerCase());
           cities.add(city);
        }
    }

}

    private void createCountryObject(){
        ArrayList <String[]> locationList= FileIO.readLocationData("countries_and_cities.csv");
        for (String[] locations:
                locationList) {

                Country country= new Country(locations[0].toLowerCase());
                countries.add(country);

        }

    }

    //We are assigning temperature array lists to the city objects  
    public void assignmentTempratureToCities() {
        for (City city : cities) {
            ArrayList<Temperature> temperatureArrayList = new ArrayList<>();
            int mounth;
            int year = 2020;
            for (int j = 0; j < 3; j++) {
                year = 2020 + j;
                for (int i = 0; i < 12; i++) {
                   mounth=i+1;

                    Temperature temperature = new Temperature(mounth, year);
                    temperatureArrayList.add(temperature);

                }
            }


            city.setTemperatureArrayList(temperatureArrayList);

        }
    }
    
    //We are assigning temperature array lists to the country objects 
    public void assignmentTempratureToCountries() {
        for (Country country : countries) {
            ArrayList<Temperature> temperatureArrayList = new ArrayList<>();
            int mounth = 0;
            int year = 2020;
            for (int j = 0; j < 3; j++) {
                year = 2020 + j;
                for (int i = 0; i < 12; i++) {
                    mounth = i + 1;
                }


                Temperature temperature = new Temperature(mounth, year);
                temperatureArrayList.add(temperature);

            }


            country.setTemperatureArrayList(temperatureArrayList);

        }
    }

    //We are assigning humidity array lists to the city objects 
    public void assignmentHumidityToCities() {
        for (City city : cities) {
            ArrayList<Humidity> humidityArrayList = new ArrayList<>();
            int mounth = 0;
            int year = 2020;
            for (int j = 0; j < 3; j++) {
                year = 2020 + j;
                for (int i = 0; i < 12; i++) {
                   mounth=i+1;



                    Humidity humidity = new Humidity(mounth, year);
                    humidityArrayList.add(humidity);
            }
                }



            city.setHumidityArrayList(humidityArrayList);

        }}

    //We are assigning wind speed array lists to the city objects 
    public void assignmentWindSpeedToCities() {
        for (City city : cities) {
            ArrayList<WindSpeed> windSpeedArraylist = new ArrayList<>();
            int mounth;
            int year = 2020;
            for (int j = 0; j < 3; j++) {
                year = 2020 + j;
                for (int i = 0; i < 12; i++) {
                   mounth=i+1;


                    WindSpeed windSpeed = new WindSpeed(mounth, year);
                    windSpeedArraylist.add(windSpeed);

                }
            }


            city.setWindSpeedArrayList(windSpeedArraylist);

        }
    }
    
    //We are assigning radiation absorbtion array lists to the city objects.
    public void assignmenRadiationAbsorbtionToCities() {
        for (City city : cities) {
            ArrayList<RadiationAbsorbtion> radiationAbsorbtionArraylist = new ArrayList<>();
            int mount;
            int year = 2020;
            for (int j = 0; j < 3; j++) {
                year = 2020 + j;
                for (int i = 0; i < 12; i++) {
                   mount=i+1;


                    RadiationAbsorbtion radiationAbsorbtion = new RadiationAbsorbtion(mount, year);
                    radiationAbsorbtionArraylist.add(radiationAbsorbtion);

                }
            }
            city.setRadiationAbsorbtionArrayList(radiationAbsorbtionArraylist);
            }}

    public ArrayList<City> getCities() {
        return cities;
    }

    public ArrayList<Country> getCountries() {
        return countries;
    }
}









