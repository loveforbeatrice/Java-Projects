package BusinessLayer;
import java.util.Random;

public abstract class Weapon {
    private final String weaponType = "weapon";
    private int additionalAttack;
    //isSkipped field is used for condition checking if a turn is missed.
    private boolean isSkipped = false;
     Weapon() {
        Random random = new Random();
        additionalAttack = random.nextInt(11)+10;
    }
    public abstract double attackType1();
    public abstract double attackType2();

    @Override
    public String toString() {
        return " " + this.getWeaponType() + " with "+ getAdditionalAttack()+" attack.";
    }
    public String getWeaponType() {
        return weaponType;
    }
    public int getAdditionalAttack() {
        return additionalAttack;
    }
    public void setAdditionalAttack(int additionalAttack) {this.additionalAttack = additionalAttack;}
    public void setIsSkippedToTrue(){this.isSkipped=true;}
    public boolean getIsSkipped(){return isSkipped;}

    }

