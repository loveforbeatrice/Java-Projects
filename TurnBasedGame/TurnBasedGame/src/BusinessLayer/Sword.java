package BusinessLayer;
import java.util.Random;
public class Sword extends Weapon{
    private final String weaponType="Sword";
    private int reduceStamina;
    public Sword(){super();}
    public double attackType1(){
        //Slash
        reduceStamina=2;
        return 1;
    }
    public double attackType2(){
        //Stab
        reduceStamina=2;
        Random random=new Random();
        int chanceOfLosing=random.nextInt(4);
        if(chanceOfLosing==0){
            return 0;
        }
        else{
            return 2;
        }
    }
    public int getReducedStamina() {return reduceStamina;}
    @Override
    public String getWeaponType() {return weaponType;}


}
