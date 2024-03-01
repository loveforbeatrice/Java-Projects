package BusinessLayer;
import java.util.Random;
public class Wolf extends Opponent{
    private final String type = "Wolf";
    private final String generalType = "opponent";

    public Wolf(int id) {
        super(id);
    }
    Random random = new Random();
    int a = random.nextInt(1938);

    public Wolf(Wolf wolf){
       super(10);

        this.setOpponentId(wolf.getOpponentId()+a);
        this.setSkipped(wolf.isSkipped());
        this.setPoint(wolf.getPoint());
        this.setAttack(wolf.getAttack());
        this.setSpeed(wolf.getSpeed());
        this.setGuard(wolf.isGuard());
    }

    public void special(Human<Weapon> HumanBeingAttacked, Turn turn) {}

    public String getGeneralType() {
        return generalType;
    }

    public String getType() {
        return type;
    }

}
