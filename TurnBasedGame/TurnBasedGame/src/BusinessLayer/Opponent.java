package BusinessLayer;
import java.util.Random;
public abstract class Opponent extends Member{
    private int opponentId;
    private final String type = "opponent";
    private int point;
    private boolean isSkipped;
    private int attack;
    private boolean guard=false;
    public final int MAXPOINTSFOROPPONENTS = 150;

    public Opponent(int id){
        super(String.valueOf(id));
        this.opponentId=id;

        point = RandomPointsAssignment();
        setSpeed(RandomSpeedAssignment());
        attack = RandomAttackAssignment();
    }

    public Opponent(Opponent opponent){
        super(opponent);
        this.opponentId=opponent.opponentId;
        this.isSkipped=opponent.isSkipped;
        this.point=opponent.point;
        this.attack=opponent.attack;
        setSpeed(opponent.getSpeed());;
        this.guard = opponent.guard;
    }
    public int RandomPointsAssignment(){
        Random random = new Random();
        return random.nextInt(50,150);
    }
    public int RandomSpeedAssignment(){
        Random random = new Random();
        return random.nextInt(91);
    }
    public int RandomAttackAssignment(){
        Random random = new Random();
        return random.nextInt(5,25);
    }
    public abstract void special(Human<Weapon> HumanBeingAttack,Turn turn);

    public void specialAttack(Human<Weapon> humanBeingAttacked ,Turn turn){this.special(humanBeingAttacked,turn);}
    public void attack(Human<Weapon> target, double modifier){
        if (target.isGuard() ){
            target.setPoint((int)(target.getPoint()-this.attack*0.25*modifier));
        }
        else{
            target.setPoint((int)(target.getPoint()-this.attack*modifier));
        }
    }
    //ödevde special güçlerin kendi adları var direkt bütün oppponent sınıfları için ayrı isimlerle yazıyorum
    //public abstract void special(Human HumanBeingAttacked);
    public void guard(){
        this.guard=true;
    }


    @Override
    public String toString() {
        return
                "Id= " + this.getOpponentId() +
                        " Type= "+ this.getType()+
                        ", point= " + this.getPoint() +
                        ", attack= " + this.getAttack() +
                        ", speed= " + this.getSpeed()+
                        "\n";
    }
    public boolean isGuard() {
        return guard;
    }
    public int getAttack() {
        return attack;
    }
    public int getPoint(){
        return point;
    }
    public void setPoint(int point){
        this.point = point;
    }
    public void setGuard(boolean guard) {
        this.guard = guard;
    }
    public boolean isSkipped() {
        return isSkipped;
    }
    public int getOpponentId() {
        return opponentId;
    }

    public void setOpponentId(int opponentId) {
        this.opponentId = opponentId;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public void setSkipped(boolean skipped) {
        isSkipped = skipped;
    }

    public String getType() {
        return type;

    }

}
