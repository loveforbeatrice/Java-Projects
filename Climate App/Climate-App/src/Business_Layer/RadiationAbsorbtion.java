package Business_Layer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
public class RadiationAbsorbtion extends ClimateMeasurement {
    private double unitAbsorbtionValue;

    private static enum radiationIntensity {
        LOW,
        MEDIUM,
        HIGH,
    }

    private  radiationIntensity radiationIntensity;

    public ArrayList<String> EnumVals(){
        ArrayList<String> EnumValArrayList = new ArrayList<>();
        for (radiationIntensity EnumVar : radiationIntensity.values()) {
            EnumValArrayList.add(String.valueOf(EnumVar));
        }
        return EnumValArrayList;
    }



    RadiationAbsorbtion(int month,int year){
        super(month,year);
        this.unitAbsorbtionValue=unitAbsorbtionValue();
        this.radiationIntensity = radiationIntensity();

    }
    public double  unitAbsorbtionValue(){
        Random random = new Random();


        double minAbsorptionValue = 5.0;
        double maxAbsorptionValue = 20.0;
        return  minAbsorptionValue + (maxAbsorptionValue - minAbsorptionValue) * random.nextDouble();


    }

    public radiationIntensity radiationIntensity() {
        Random random = new Random();
        int randomIndex = random.nextInt(radiationIntensity.values().length); //int randomIndex = random.nextInt(3)
        this.radiationIntensity = radiationIntensity.values()[randomIndex];

        return radiationIntensity;
    }

    public double getUnitAbsorbtionValue() {
        return unitAbsorbtionValue;
    }

    public radiationIntensity getRadiationIntensity(){
        return radiationIntensity;
    }
    public boolean equals(RadiationAbsorbtion otherRA) {
    	if(otherRA.getRadiationIntensity() == this.getRadiationIntensity()) {
    		return true;
    	}else {return false;
    	
    	}
    }


    public String toString(){
        return "year: "+getYear()+"month: " + getMonth()+ "radiation intensity: " +radiationIntensity;
       
    }


}
