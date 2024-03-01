package Business_Layer;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Query {

    ClimateRecord record;
    public Query(){
        this.record=new ClimateRecord();

        method();

    }


//displaying the menu with the given method
    public int userInterface(){
        Scanner input = new Scanner(System.in);

        int choice = 0;
        boolean isValidChoice = false;

        while (!isValidChoice) {
            System.out.println("\n--------------------------------------\n--------------------------------------\n[1] Calculate average temperature for a country according to temperature unit and year.\n" +
                    "[2] Calculate average temperature for a city according to temperature unit and year.\n" +
                    "[3] Calculate average wind speed for a city according to speed unit and year.\n" +
                    "[4] Calculate average humidity of a city for every year.\n" + "[5] Count how many times a year a specific radiation intensity value appears.\n" +
                    "[6] Calculate the 'felt temperature' value for a specific month.\n" +
                    "[7] Exit the application\n--------------------------------------\n--------------------------------------\n");

            System.out.println("Choose one (1-7): ");

            try {
                choice = input.nextInt();

                if (choice >= 1 && choice <= 7) {
                    isValidChoice = true;
                } else {
                    System.out.println("Invalid choice. Please choose a number between 1 and 7.");
                }
            } catch (Exception e) {
                input.nextLine(); // Consume the invalid input to avoid an infinite loop
                System.out.println("Invalid input. Please enter a valid number.");
            }
        }

        return choice;

    }
    
    //This function channels us to the methods 
    public void method(){
        switch (userInterface()){
            case 1:
            	calculateAverageTempratureForCountry();
            	method();
                break;
            case 2:
            	calculateAverageTempratureForCity();
            	method();
                break;
            case 3:
            	calculateAverageWindSpeedForCity();
            	method();
                break;
            case 4:
            	calculateAverageHumidityForCity ();
            	method();
                break;
            case 5:
            	countRadiation();
            	method();
            	break;
            case 6:
            	calculateFeltValue();
            	method();
            	break;
            case 7:
            	System.out.println("System off");
            	System.exit(0);
            	break;
        }
    }
    
    //Calculating the average temperatures for countries it also returns the output of the first question
    public void calculateAverageTempratureForCountry(){
        String countryName= askCountryLocation();
        int temperatureTypeId=askTemperatureType();
        int year=askYear();
        double sumTemp=0;
        int tempCount=0;
        double averageTemp = 0;
        Country findCountry = null;
        for (Country country:
                record.getCountries()) {
            if(country.nameCompareTo(countryName)){
                findCountry=country;
            } else{
            }}
        if(findCountry==null){
            System.out.println("Country not found please try again");
           calculateAverageTempratureForCountry();
           method();
            System.exit(0);
        }
        for (Temperature temp : findCountry.getTemperatureArrayList()
        ) {
            if(temp.getYear()==year){
                sumTemp+=temp.convertUnit(temperatureTypeId);
                tempCount+=1;
            }
        }
        averageTemp = sumTemp/tempCount;
        System.out.println("Average temperature of " + countryName.toUpperCase() + " in " + temperatureTypeIdtoString(temperatureTypeId) + " in " + year + " is: " + String.format("%.2f",averageTemp));
    }

    


  //Calculating the average temperatures for cities it also returns the output of the second question
    public void calculateAverageTempratureForCity() {
        String cityName=askCityLocation();
        int temperatureTypeId=askTemperatureType();
        int year=askYear();
        double sumTemp=0;
        int tempCount=0;
        double averageTempForCity = 0;
        City findCity = null;
        for (City city:
                record.getCities()) {

            if(city.nameCompareTo(cityName)){
                findCity=city;
            } else{}

        }
        if(findCity==null){
            System.out.println("City not found please try again");
            calculateAverageTempratureForCity();
            method();
            System.exit(0);
        }
        for (Temperature temp : findCity.getTemperatureArrayList()
        ) {
            if(temp.getYear()==year){
                sumTemp+=temp.convertUnit(temperatureTypeId);
                tempCount+=1;
            }
        }
        averageTempForCity = sumTemp/tempCount;
        System.out.println("Average temperature of " + cityName.toUpperCase() + " in " + temperatureTypeIdtoString(temperatureTypeId) + " in " + year + " is: " + String.format("%.2f",averageTempForCity));

    }


  //Calculating the average wind speed for cities it also returns the output of the third question
    public void calculateAverageWindSpeedForCity() {
        String nameOfCity = askCityLocation();
        int month = askMonth();
        int windSpeedUnitId = askWindSpeedUnit();
        double windSpeedAverage = 0.0;
        City findCity = null;
        for (City city :
                record.getCities()) {

            if (city.nameCompareTo(nameOfCity)) {

                findCity = city;
            } else {
            }
        }
        if (findCity == null) {
            System.out.println("City not found please try again");
            calculateAverageWindSpeedForCity();
            method();
            System.exit(0);
        }
        int count = 0;
        for (WindSpeed windSpeed : findCity.getWindSpeedArrayList()) {
            switch (windSpeedUnitId) {
                case 1:
                    if (windSpeed.getMonth()==month) {

                        windSpeedAverage += windSpeed.getWindSpeedMetersPerSecond();
                        count++;
                    }
                    break;
                case 2:
                    if (windSpeed.getMonth()==month) {
                        windSpeedAverage += windSpeed.toPerKmPerHour();
                        count++;
                    }
                    break;
            }
        }
        windSpeedAverage = windSpeedAverage/count;

        System.out.println("Average wind speed in " + windSpeedUnitIdtoString(windSpeedUnitId) + " in " + nameOfCity.toUpperCase() + " in " + month + ". month is " + String.format("%.2f",windSpeedAverage));
    }


  //Calculating the average humidities for cities it also returns the output of the fourth question
    public void calculateAverageHumidityForCity () {
        String cityName=askCityLocation();
        double sum=0;
        int count=0;
        double averageHumidity = 0;
        City findCity=null;
        for (City city: record.getCities()){
            if (city.nameCompareTo(cityName)){
                findCity=city;
            }
        }  if(findCity==null){
            System.out.println("City not found please try again");
            calculateAverageHumidityForCity ();
            method();
            System.exit(0);}
        for (Humidity humidity: findCity.getHumidityArrayList()){
            sum += humidity.getHumidity();
            count+=1;
        }



        averageHumidity = sum/count;
        System.out.println("Average Humidty of the previous three years" + " in " +  cityName.toUpperCase() + " is: " + String.format("%.2f",averageHumidity));
        
    }
    

    //Calculating the radiation count for cities it also returns the output of the fifth question
    public void countRadiation(){
    	String cityName=askCityLocation();
        int radiationIntensityId=askRadiationIntensity();
        int low = 0,medium = 0,high = 0;
        int year=askYear();
        City findCity=null;
        for (City city : record.getCities()) {
            if (city.getName().equals(cityName)){
                findCity=city;}}
            if(findCity==null){
               System.out.println("City not found please try again");
               countRadiation();
               method();
               System.exit(0);
        }
        for (RadiationAbsorbtion radiationAbsorbtion : findCity.getRadiationAbsorbtionArrayList()) {
            if (year == radiationAbsorbtion.getYear()) {
                if (radiationIntensityId == 1) {
                    if (String.valueOf(radiationAbsorbtion.getRadiationIntensity()) == radiationAbsorbtion.EnumVals().get(0)) {
                        low++;}
                } else if (radiationIntensityId == 2) {
                	if (String.valueOf(radiationAbsorbtion.getRadiationIntensity()) == radiationAbsorbtion.EnumVals().get(1)) {
                        medium++;}
                }else if (radiationIntensityId == 3) {
                	if(String.valueOf(radiationAbsorbtion.getRadiationIntensity()) == radiationAbsorbtion.EnumVals().get(2)) {
                        high++;}}}
        }if ((radiationIntensityId == 1)){
        	 System.out.println("Count of Low radiation intensity in: " + cityName.toUpperCase() + " in " + year + " is: " + low );
        }else if (radiationIntensityId == 2){
        	 System.out.println("Count of Medium radiation intensity in: " + cityName.toUpperCase() + " in " + year + " is: " + medium );
        }else if (radiationIntensityId == 3){
        	 System.out.println("Count of High radiation intensity in: " + cityName.toUpperCase() + " in " + year + " is: " + high );	
        }else {}}

    
  //Calculating the felt value for cities it also returns the output of the sixth question
    public void calculateFeltValue(){
        String cityName=askCityLocation();
        int monthId=askMonth();
        int year=askYear();
        int index=0;
        City findCity = null;
        for (City city:
                record.getCities()) {

            if(city.nameCompareTo(cityName)){
                findCity=city;
            } else{}

        }
        if(findCity==null){
            System.out.println("City not found please try again");
            calculateFeltValue();
            method();
            System.exit(0);
        }
        for (int i=0;i<findCity.getTemperatureArrayList().size();i++) {
            if(findCity.getTemperatureArrayList().get(i).getYear()==year){
                if(findCity.getTemperatureArrayList().get(i).getMonth()==monthId){
                if(findCity.getTemperatureArrayList().get(i).getMonth()==monthId){
                	index=i;
                }
            }
        }

    }System.out.println("Felt value in " + cityName.toUpperCase() + " in " + monthId + ". month in " + year + " is: " + String.format("%.2f",findCity.calculteFelt(index)));
    }
    
    
    //helper method used in the question output methods
    public String askCountryLocation () {
        System.out.println("Enter a country name: ");
        Scanner input = new Scanner(System.in);
        String location = input.next().toLowerCase();
        for (int i = 0; i < 10; i++) {
            if (location.contains(Integer.toString(i))) {
                System.out.println("Please enter a valid country name!");
                return askCountryLocation();
            }
        }
        return location;
    }
    
    //helper method used in the question output methods
    public String askCityLocation () {
        System.out.println("Enter a city name: ");
        Scanner input = new Scanner(System.in);
        String location = input.next().toLowerCase();
        for (int i = 0; i < 10; i++) {
            if (location.contains(Integer.toString(i))) {
                System.out.println("Please enter a valid city name!");
            
                return askCityLocation();
            }
        }
        return location;
    }
    
    
    //helper method used in the question output methods
    public int askTemperatureType() {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Celsius, [2] Fahrenheit, [3] Kelvin");

        int typeId;
        try {
            typeId = input.nextInt();
            if (typeId >= 1 && typeId <= 3) {
                return typeId;
            } else {
                System.out.print("Incorrect option input! Please reenter another option input: ");
                return askTemperatureType();
            }
        } catch (java.util.InputMismatchException e) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            input.next(); // clear the buffer
            return askTemperatureType();
        }
    }
    
    //helper methods for displaying the outputs
    public String temperatureTypeIdtoString(int num) {
    	if (num == 1) {return "Celcius";}
    	else if (num == 2) {return "Fahrenheit";}
    	else {return "Kelvin";}
    }

    //helper method used in the question output methods
    public int askYear () {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] 2020, [2] 2021, [3] 2022");
        int yearId;
        try {
            yearId = Integer.parseInt(input.next());
            if (yearId >= 1 && yearId <= 3) {
                return 2019 + yearId; 
            } else {
                System.out.print("Incorrect option input! Please reenter another option input: ");
                return askYear();
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            return askYear();
        }
    }
    
     //helper method used in the question output methods
    public int askWindSpeedUnit () {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Meter/Seconds, [2] Kilometer/Hours");
        try {
            int unitId = Integer.parseInt(input.next());
            if (unitId == 1 || unitId == 2) {
                return unitId;
            } else {
                System.out.print("Incorrect option input! Please reenter another option input: ");
                return askWindSpeedUnit();
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            return askWindSpeedUnit();
        }
    }
    //helper methods for displaying the outputs
    public String windSpeedUnitIdtoString(int num) {
    	if (num == 1) {return " Meter/Seconds";}
    	else {return "Kilometer/Hours";}
    }

    
  //helper method used in the question output methods
    public int askRadiationIntensity () {
        Scanner input = new Scanner(System.in);
        System.out.println("[1] Low, [2] Medium, [3] High");
        int radiationIntensityId;
        try {
            radiationIntensityId = Integer.parseInt(input.next());
            if (radiationIntensityId >= 1 && radiationIntensityId <= 3) {
                return radiationIntensityId;
            } else {
                System.out.print("Incorrect option input! Please reenter another option input: ");
                return askRadiationIntensity();
            }
        } catch (NumberFormatException e) {
            System.out.print("Invalid input! Please enter a valid integer: ");
            return askRadiationIntensity();
        }
    }
    
    //helper method used in the question output methods
    public int askMonth () {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter a number between 1 to 12");
        int numMonth = input.nextInt();
        try {
            if(numMonth<1 || numMonth>12){
               return askMonth();
            }else if(numMonth>=1 || numMonth<=12 ){
                return numMonth;
            }else{}
        } catch(InputMismatchException e){
           return askMonth();
        }

        return numMonth;
    }
}




