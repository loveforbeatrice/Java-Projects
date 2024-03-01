package BusinessLayer;

public class Goblin extends Opponent{
    private final String type = "Goblin"; // We use it for displaying in menu
    private final String generalType = "opponent"; // We use it for displaying in menu


    public Goblin(int id) {
        super(id);
    }

    public String getType() {
        return type;
    }

    public void special(Human<Weapon> HumanBeingAttacked, Turn turn) {
    turn.setAttackModifier(0.7);
    attack(HumanBeingAttacked,turn.getAttackModifier());
    //tbgame de kontrol sağlamamız lazım(if else) turn için

    }
    public String getGeneralType() {
        return generalType;
    }
}