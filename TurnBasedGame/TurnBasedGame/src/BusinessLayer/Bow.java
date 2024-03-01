package BusinessLayer;

public class Bow extends Weapon{


    private final String weaponType = "Bow"; // We use it for displaying in menu
    private int reduceStamina;
    public Bow() {super();}


    public double attackType1(){
        //Single Arrow
        reduceStamina=1;

        return 0.8;
    }

    public double attackType2(){
        //Double Arrow
        reduceStamina=3;

       return 2.5;

    }
    public String getWeaponType() {
        return weaponType;
    }
    public int getReducedStamina() {
        return reduceStamina;
    }
}
