package BusinessLayer;
import java.util.Random;

public abstract class Human<W extends Weapon>  extends Member implements ICharacter<W> {
    private final String type = "human";
    private final String generalType = "human";
    private W weapon;
    private int point;
    private int attack;
    private String job;
    private boolean isSkip;
    public String getName() {
        return name;
    }
    private String name;
    private int stamina = 10;
    private boolean guard = false;
    private int reduceStamina;
    private boolean isSpecialUsed = false;


    public Human(String name) {
        super(name);
        point = RandomPointsAssignment();
        setSpeed(RandomSpeedAssignment());
        attack = RandomAttackAssignment();
    }

    @Override
    public int RandomPointsAssignment() {
        Random random = new Random();
        return random.nextInt(100, 151);
    }

    @Override
    public int RandomSpeedAssignment() {
        Random random = new Random();
        return random.nextInt(10,100);
    }

    @Override
    public int RandomAttackAssignment() {
        Random random = new Random();
        return random.nextInt(20,41);
    }

    @Override
    public void run() {}
    public void modifierAttack(Opponent opponent,Turn turn) {
        stamina--;
        if(opponent.isGuard()) {

            opponent.setPoint((int) (opponent.getPoint() - turn.getAttackModifier() * attack * (1 / 2)));
        }else{

            opponent.setPoint((int)(opponent.getPoint()- turn.getAttackModifier()* attack));
        }
    }
    @Override
    public void punch(Opponent opponent,Turn turn) {
        stamina--;
        if(opponent.isGuard()) {

            opponent.setPoint((int) (opponent.getPoint() - turn.getAttackModifier()* 0.8 * attack * (1 / 2)));
        }else{

            opponent.setPoint((int)(opponent.getPoint()- turn.getAttackModifier()*0.8* attack));
        }
    }

    public void specialAction(Opponent opponentThatHumanIsAttacking,Turn turn) {
        setSpecialUsedToTrue();

        opponentThatHumanIsAttacking.setPoint((int)(opponentThatHumanIsAttacking.getPoint()-attack*turn.getAttackModifier()));
    }

    public void guard(){
        this.guard=true;
        stamina=+3;
    }
    public <W extends Weapon> void attackWithWeapon(Opponent opponent,double modifier, int input ){
        if(input==1) {
            opponent.setPoint((int)(opponent.getPoint() - (attack + weapon.getAdditionalAttack()) * weapon.attackType1()));
        }else if(input==2){
            //This is mainly here for spear because it has a special action which can lead to skipping a turn
            setHumanisSkipAccordingToWeaponIsSkipped();
            opponent.setPoint((int)(opponent.getPoint() - (attack + weapon.getAdditionalAttack()) * weapon.attackType2()));
        }
    }

    public boolean isGuard() {
        return guard;
    }

    @Override
    public String toString() {
        return
                " name= " + this.getName() +
                        ", job='" + this.getJob() + '\'' +
                        " point= " + this.getPoint() +
                        ", stamina=" + this.getStamina() +
                        ", attack=" + this.getAttack() +
                        ", speed=" + this.getSpeed() +
                        this.getWeapon().toString()+
                        "\n";
    }

    public int getStamina(){
        return stamina;
    }
    public void setStamina(int stamina){this.stamina = stamina;}
    public int getAttack() {return attack;}
    public int getReducedStamina() {return reduceStamina;}
    public void setWeapon(W weapon) {this.weapon = weapon;}
    public String getGeneralType() {return generalType;}
    public void setPoint(int point) {this.point = point;}
    public int getPoint() {return point;}
    public Weapon getWeapon() {return weapon;}
    public String getJob() {return job;}
    public void setName(String name) {this.name = name;}
    public String getType() {return type;}
    //This method is mainly for Spear which has a special attack that can make our Human obj to skip turn.
    public void setHumanisSkipAccordingToWeaponIsSkipped(){this.isSkip = this.weapon.getIsSkipped();}
    public boolean getIsSpecialUsed(){return isSpecialUsed;}
    public void setSpecialUsedToTrue(){this.isSpecialUsed = true;}

}
