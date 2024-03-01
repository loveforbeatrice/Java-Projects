package BusinessLayer;

import java.util.Random;

public class Spear extends Weapon {

    private final String weaponType = "Spear";
    private int reduceStamina;


    public Spear(){super();}

    //Stab
    public double attackType1(){

        reduceStamina=2;
        return 1.1;

    }

    //Thrown
    public double attackType2(){
        //When the Spear is thrown IsSkipped
        //attribute is set to be true
        //So we can set IsSkipped field
        //in the Human that has the weapon as True
        setIsSkippedToTrue();

        reduceStamina=2;
        return 2;
    }
    public String getWeaponType() {
        return weaponType;
    }

    public int getReducedStamina() {
        return reduceStamina;
    }
}
