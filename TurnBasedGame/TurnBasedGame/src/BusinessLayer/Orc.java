package BusinessLayer;

public class Orc extends Opponent{
    private final String type = "Orc";
    private final String generalType = "opponent";
    public Orc(int id) {
        super(id);
    }
    public void special(Human<Weapon> HumanBeingAttacked, Turn turn){
        turn.setAttackModifier(2);
        attack(HumanBeingAttacked,turn.getAttackModifier());
        turn.setAttackModifier(1);
        super.setSkipped(true);
    }
    public String getGeneralType() {
        return generalType;
    }
    public String getType() {
        return type;
    }
}
